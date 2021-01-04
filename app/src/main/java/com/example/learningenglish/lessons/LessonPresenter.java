package com.example.learningenglish.lessons;

import android.content.Context;
import com.example.learningenglish.model.CategoryEntity;
import repository_category_entity.CategoryEntityRepository;
import repository_category_entity.ICategoryEntityRepository;

public class LessonPresenter implements LessonContract.Presenter {

    private ICategoryEntityRepository categoryEntityRepository;
    private LessonContract.View view;

    public LessonPresenter(LessonContract.View view, Context context) {
        categoryEntityRepository = new CategoryEntityRepository(context);
        this.view = view;
    }

    @Override
    public void getCategoryEntityFromDatabase(int id) {
        CategoryEntity entities = categoryEntityRepository.getCategoryEntity(id);
        if (entities == null) {
            view.showMessage("Сущность темы не найдена. ID = " + id);
        } else {
            view.showCategoryEntity(entities);
        }
    }
}
