package com.example.learningenglish.main;

import android.content.Context;

import com.example.learningenglish.model.ThemeProperty;
import com.example.learningenglish.repository.theme_property.IThemePropertyRepository;
import com.example.learningenglish.repository.theme_property.ThemePropertyRepository;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private IThemePropertyRepository repository;
    private MainContract.View view;

    public MainPresenter(MainContract.View view, Context context) {
        this.view = view;
        repository = new ThemePropertyRepository(context);
    }

    @Override
    public void getDataFromDatabase() {
        List<ThemeProperty> properties = repository.getThemeProperties();
        if (properties == null) {
            view.showMessage("Нет данных в БД.");
        } else {
            view.showThemeProperties(properties);
        }
    }
}
