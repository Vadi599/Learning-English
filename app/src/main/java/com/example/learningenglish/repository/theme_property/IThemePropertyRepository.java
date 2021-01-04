package com.example.learningenglish.repository.theme_property;

import com.example.learningenglish.model.ThemeProperty;

import java.util.List;

public interface IThemePropertyRepository {

    ThemeProperty getThemeProperty(int themeId);

    List<ThemeProperty> getThemeProperties();

}
