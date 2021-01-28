package com.example.learningenglish.repository_category_entity;

import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.model.ResourcesOfCategory;

import java.util.List;

public interface ICategoryEntityRepository {

    List<CategoryEntity> getCategoryEntity();

    List<ResourcesOfCategory> getResource(String category);

}
