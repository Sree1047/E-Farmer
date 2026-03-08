package com.mitron.onlinegrocery.service;

import java.util.List;

import com.mitron.onlinegrocery.domain.models.service.CategoryServiceModel;

public interface CategoryService {

    CategoryServiceModel addCategory(CategoryServiceModel categoryServiceModel);

    List<CategoryServiceModel> findAllCategories();

    CategoryServiceModel findCategoryById(String id);

    CategoryServiceModel editCategory(String id, CategoryServiceModel categoryServiceModel);

    CategoryServiceModel deleteCategory(String id);

    List<CategoryServiceModel> findAllFilteredCategories();
}
