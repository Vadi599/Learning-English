package com.example.learningenglish.main;

import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.model.ThemeProperty;

import java.util.List;

public interface MainContract {

    interface View {

        void showMessage(String message);

        void showThemeProperties(List<ThemeProperty> properties);

        void showSelectionMenu(ThemeProperty property);
    }

    interface Presenter {

        void getDataFromDatabase();

    }

}
