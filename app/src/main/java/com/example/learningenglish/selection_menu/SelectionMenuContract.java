package com.example.learningenglish.selection_menu;
import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.model.ThemeProperty;
import com.example.learningenglish.model.ResourcesOfCategory;
import java.util.List;

public interface SelectionMenuContract {

    interface View {

        void showThemeProperty(ThemeProperty properties);

        void showMessage(String message);

        void showCategoryEntities(List<CategoryEntity> entities);

        void showLesson(CategoryEntity categoryEntity);

        void showResources(List<ResourcesOfCategory> resources);

    }

    interface Presenter {

        void getThemePropertyFromDatabase(int id);

        void getDataFromDatabase();

        void getResourcesFromDatabase(String category);
    }
}