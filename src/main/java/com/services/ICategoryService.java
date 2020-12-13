package com.services;

import com.models.CategoryEntity;

public interface ICategoryService {
    Iterable<CategoryEntity> findAll();
    Iterable<CategoryEntity> findLimit();
    CategoryEntity findById(int id);
    void save(CategoryEntity categoryEntity);
    void delete(CategoryEntity categoryEntity);
}
