package repository_category_entity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.learningenglish.DBHelper;
import com.example.learningenglish.model.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityRepository implements ICategoryEntityRepository {
    private DBHelper dbHelper;
    SQLiteDatabase db;

    public CategoryEntityRepository(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public CategoryEntity getCategoryEntity(int entityId) {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("FAMILY",
                new String[]{"WORD_RU", "WORD_EN", "IMAGE_RESOURCE_ID"}, "_id=?",
                new String[]{Integer.toString(entityId)}, null, null, null);
        if (cursor.moveToFirst()) {
            String wordRu = cursor.getString(0);
            String wordEn = cursor.getString(1);
            int imageResourceId = cursor.getInt(2);
            CategoryEntity categoryEntity = new CategoryEntity(entityId, imageResourceId, wordEn, wordRu);
            return categoryEntity;
        } else {
            return null;
        }
    }

    @Override
    public List<CategoryEntity> getCategoryEntity() {
        Cursor cursor = db.query("FAMILY", null, null, null, null, null, null);
        ArrayList<CategoryEntity> entities = new ArrayList<>();
        if (cursor.moveToFirst()) {
            int idColIndex = cursor.getColumnIndex("_id");
            int wordRuIndex = cursor.getColumnIndex("WORD_RU");
            int wordEnIndex = cursor.getColumnIndex("WORD_EN");
            int imageResourceIdIndex = cursor.getColumnIndex("IMAGE_RESOURCE_ID");
            do {
                int id = cursor.getInt(idColIndex);
                String wordRu = cursor.getString(wordRuIndex);
                String wordEn = cursor.getString(wordEnIndex);
                int imageResourceId = cursor.getInt(imageResourceIdIndex);
                CategoryEntity categoryEntity = new CategoryEntity(id, imageResourceId, wordEn, wordRu);
                entities.add(categoryEntity);
            } while (cursor.moveToNext());
            cursor.close();
            return entities;
        } else {
            return null;
        }
    }
}
