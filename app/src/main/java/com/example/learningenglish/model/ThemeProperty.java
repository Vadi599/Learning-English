package com.example.learningenglish.model;

public class ThemeProperty {

    int id;
    String typeOfTheme;
    String countOfWords;

    public ThemeProperty(int id, String typeOfTheme, String countOfWords) {
        this.id = id;
        this.typeOfTheme = typeOfTheme;
        this.countOfWords = countOfWords;
    }

    public int getId() {
        return id;
    }

    public String getTypeOfTheme() {
        return typeOfTheme;
    }

    public String getCountOfWords() {
        return countOfWords;
    }

}
