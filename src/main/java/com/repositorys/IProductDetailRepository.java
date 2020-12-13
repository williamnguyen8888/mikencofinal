package com.repositorys;

import com.models.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductDetailRepository extends CrudRepository<ProductEntity,Integer> {
}
