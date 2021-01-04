package repository_category_entity;

import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.model.ThemeProperty;

import java.util.List;

public interface ICategoryEntityRepository {

    CategoryEntity getCategoryEntity(int entityId);

    List<CategoryEntity> getCategoryEntity();

}
