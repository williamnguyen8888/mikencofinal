package com.repositorys;

import com.models.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<CategoryEntity,Integer> {
}
