package com.example.learningenglish.model;

public class CategoryEntity {

    int id;
    String word_ru;
    String word_en;
    String category;
    int imageResourceId;


    public CategoryEntity(int id, String word_ru, String word_en, String category, int imageResourceId) {
        this.id = id;
        this.word_ru = word_ru;
        this.word_en = word_en;
        this.category = category;
        this.imageResourceId = imageResourceId;
    }

    public CategoryEntity(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

}
