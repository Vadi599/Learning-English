package com.example.learningenglish.lessons;

import com.example.learningenglish.model.CategoryEntity;

public interface LessonContract {

    interface View {

        void showCategoryEntity(CategoryEntity entities);

        void showMessage(String message);

    }

    interface Presenter {

        void getCategoryEntityFromDatabase(int id);

    }
}
