package com.example.learningenglish.selection_menu;

import android.content.Context;

import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.model.ThemeProperty;
import com.example.learningenglish.repository.theme_property.IThemePropertyRepository;
import com.example.learningenglish.repository.theme_property.ThemePropertyRepository;

import java.util.List;

import com.example.learningenglish.repository_category_entity.CategoryEntityRepository;
import com.example.learningenglish.repository_category_entity.ICategoryEntityRepository;
import com.example.learningenglish.model.ResourcesOfCategory;


public class SelectionMenuPresenter implements SelectionMenuContract.Presenter {

    private IThemePropertyRepository repository;
    private SelectionMenuContract.View view;
    private ICategoryEntityRepository categoryEntityRepository;

    public SelectionMenuPresenter(SelectionMenuContract.View view, Context context) {
        this.view = view;
        repository = new ThemePropertyRepository(context);
        categoryEntityRepository = new CategoryEntityRepository(context);
    }

    @Override
    public void getThemePropertyFromDatabase(int id) {
        ThemeProperty properties = repository.getThemeProperty(id);
        if (properties == null) {
            view.showMessage("Свойство темы не найдено. ID = " + id);
        } else {
            view.showThemeProperty(properties);
        }
    }

    @Override
    public void getDataFromDatabase() {
        List<CategoryEntity> categoryEntities = categoryEntityRepository.getCategoryEntity();
        if (categoryEntities == null) {
            view.showMessage("Нет данных в БД.");
        } else {
            view.showCategoryEntities(categoryEntities);
        }
    }

    @Override
    public void getResourcesFromDatabase(String category) {
        List<ResourcesOfCategory> resourceList = categoryEntityRepository.getResource(category);
        if (resourceList == null) {
            view.showMessage("Нет ресурсов в БД.");
        } else {
            view.showResources(resourceList);
        }
    }
}
