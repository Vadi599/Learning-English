package com.example.learningenglish.model;

public class Category {

    private String categoryName;
    private int CategoryImageResourceId;

    public Category(String categoryName, int categoryImageResourceId) {
        this.categoryName = categoryName;
        CategoryImageResourceId = categoryImageResourceId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryImageResourceId() {
        return CategoryImageResourceId;
    }

}




