package com.example.learningenglish;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "English_self-study_guide";
    public static final int VERSION = 2;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, 0, VERSION);
    }

    private void insertThemeProperty(SQLiteDatabase db, String typeOfTheme, String countOfWords) {
        ContentValues themeValues = new ContentValues();
        themeValues.put("TYPE_OF_THEME", typeOfTheme);
        themeValues.put("COUNT_OF_WORDS", countOfWords);
        db.insert("THEME", null, themeValues);
    }

    private void insertLesson(SQLiteDatabase db, String wordRu, String wordEn, int resourceId) {
        ContentValues lessonFriendsAndFamily = new ContentValues();
        lessonFriendsAndFamily.put("WORD_RU", wordRu);
        lessonFriendsAndFamily.put("WORD_EN", wordEn);
        lessonFriendsAndFamily.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("FAMILY", null, lessonFriendsAndFamily);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE THEME(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "TYPE_OF_THEME TEXT,"
                    + "COUNT_OF_WORDS TEXT);");
            insertThemeProperty(db, "Семья и друзья", "10");
            insertThemeProperty(db, "Части тела", "11");
            insertThemeProperty(db, "Одежда", "9");
            insertThemeProperty(db, "Цифры", "13");
            insertThemeProperty(db, "Цвета", "10");
            insertThemeProperty(db, "Фрукты и овощи", "11");
            insertThemeProperty(db, "Еда", "13");
            insertThemeProperty(db, "Школа", "10");
            insertThemeProperty(db, "Погода и природа", "15");
            insertThemeProperty(db, "Животные", "10");
            db.execSQL("CREATE TABLE FAMILY(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "WORD_RU TEXT,"
                    + "WORD_EN TEXT,"
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertLesson(db, "мама", "mother", R.drawable.mother);
            insertLesson(db, "папа", "father", R.drawable.father);
            insertLesson(db, "брат", "brother", R.drawable.brother);
            insertLesson(db, "сестра", "sister", R.drawable.sister);
            insertLesson(db, "сын", "son", R.drawable.son);
            insertLesson(db, "дочь", "daughter", R.drawable.daughter);
            insertLesson(db, "бабушка", "grandmother", R.drawable.grandmother);
            insertLesson(db, "дедушка", "grandfather", R.drawable.grandfather);
            insertLesson(db, "родители", "parents", R.drawable.parents);
            insertLesson(db, "друзья", "friends", R.drawable.friends);
        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE THEME ADD COLUMN FAVORITE NUMERIC;");
            db.execSQL("ALTER TABLE FAMILY ADD COLUMN FAVORITE NUMERIC;");
        }
    }
}
