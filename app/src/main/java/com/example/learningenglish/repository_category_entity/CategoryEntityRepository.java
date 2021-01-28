package com.example.learningenglish.repository_category_entity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.learningenglish.DBHelper;
import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.model.ResourcesOfCategory;

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
    public List<ResourcesOfCategory> getResource(String category) {
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from LESSON where CATEGORY = ?", new String[]{category});
        ArrayList<ResourcesOfCategory> resources = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String wordRus = cursor.getString(1);
                String wordEng = cursor.getString(2);
                int imageResourceId = cursor.getInt(4);
                ResourcesOfCategory resourcesOfCategory = new ResourcesOfCategory(wordRus, wordEng, category, imageResourceId);
                resources.add(resourcesOfCategory);
            } while (cursor.moveToNext());
            cursor.close();
            return resources;
        } else {
            return null;
        }
    }

    @Override
    public List<CategoryEntity> getCategoryEntity() {
        Cursor cursor = db.query("LESSON", null, null, null, null, null, null);
        ArrayList<CategoryEntity> entities = new ArrayList<>();
        if (cursor.moveToFirst()) {
            int idColIndex = cursor.getColumnIndex("_id");
            int wordRuIndex = cursor.getColumnIndex("WORD_RU");
            int wordEnIndex = cursor.getColumnIndex("WORD_EN");
            int categoryIndex = cursor.getColumnIndex("CATEGORY");
            int imageResourceIdIndex = cursor.getColumnIndex("IMAGE_RESOURCE_ID");
            do {
                int id = cursor.getInt(idColIndex);
                String wordRu = cursor.getString(wordRuIndex);
                String wordEn = cursor.getString(wordEnIndex);
                String category = cursor.getString(categoryIndex);
                int imageResourceId = cursor.getInt(imageResourceIdIndex);
                CategoryEntity categoryEntity = new CategoryEntity(id, wordEn, wordRu, category, imageResourceId);
                entities.add(categoryEntity);
            } while (cursor.moveToNext());
            cursor.close();
            return entities;
        } else {
            return null;
        }
    }
}
