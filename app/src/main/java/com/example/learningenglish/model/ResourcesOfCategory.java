package com.example.learningenglish.model;

public class ResourcesOfCategory {

    String wordRu;
    String wordEn;
    String categoryOfWords;
    int imageResourceId;

    public ResourcesOfCategory(String wordRu, String wordEn, String categoryOfWords, int imageResourceId) {
        this.wordRu = wordRu;
        this.wordEn = wordEn;
        this.categoryOfWords = categoryOfWords;
        this.imageResourceId = imageResourceId;
    }

    public String getWordRu() {
        return wordRu;
    }

    public String getWordEn() {
        return wordEn;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

}
