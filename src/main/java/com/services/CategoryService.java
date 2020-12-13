package com.services;

import com.models.AccountEntity;
import com.models.CategoryEntity;
import com.repositorys.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Iterable<CategoryEntity> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Iterable<CategoryEntity> findLimit() {
        Query query = entityManager.createQuery(
                "SELECT a FROM CategoryEntity a").setMaxResults(5);
        Iterable<CategoryEntity> categoryEntityList =  query.getResultList();
        return categoryEntityList;
    }

    @Override
    public CategoryEntity findById(int id) {
        return iCategoryRepository.findOne(id);
    }

    @Override
    public void save(CategoryEntity categoryEntity) {
        iCategoryRepository.save(categoryEntity);
    }

    @Override
    public void delete(CategoryEntity categoryEntity) {
        iCategoryRepository.delete(categoryEntity);
    }
}
