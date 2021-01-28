package com.example.learningenglish.repository.theme_property;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.learningenglish.DBHelper;
import com.example.learningenglish.model.ThemeProperty;
import java.util.ArrayList;
import java.util.List;

public class ThemePropertyRepository implements IThemePropertyRepository {
    private DBHelper dbHelper;
    SQLiteDatabase db;

    public ThemePropertyRepository(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public ThemeProperty getThemeProperty(int themeId) {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("THEME",
                new String[]{"TYPE_OF_THEME", "COUNT_OF_WORDS"}, "_id=?",
                new String[]{Integer.toString(themeId)}, null, null, null);
        if (cursor.moveToFirst()) {
            String typeOfTheme = cursor.getString(0);
            String countOfWords = cursor.getString(1);
            ThemeProperty themeProperty = new ThemeProperty(themeId, typeOfTheme, countOfWords);
            cursor.close();
            return themeProperty;
        } else {
            return null;
        }
    }

    @Override
    public List<ThemeProperty> getThemeProperties() {
        Cursor cursor = db.query("THEME", null, null, null, null, null, null);
        ArrayList<ThemeProperty> properties = new ArrayList<>();
        if (cursor.moveToFirst()) {
            int idColIndex = cursor.getColumnIndex("_id");
            int typeOfThemeIndex = cursor.getColumnIndex("TYPE_OF_THEME");
            int countOfWordsIndex = cursor.getColumnIndex("COUNT_OF_WORDS");
            do {
                int id = cursor.getInt(idColIndex);
                String typeOfTheme = cursor.getString(typeOfThemeIndex);
                String countOfWords = cursor.getString(countOfWordsIndex);
                ThemeProperty themeProperty = new ThemeProperty(id, typeOfTheme, countOfWords);
                properties.add(themeProperty);
            } while (cursor.moveToNext());
            cursor.close();
            return properties;
        } else {
            return null;
        }
    }
}


