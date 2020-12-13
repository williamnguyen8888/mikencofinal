package com.services;

import com.models.ProductEntity;

public interface IProductService {
    Iterable<ProductEntity> findAll();
    ProductEntity finById(int id);
    void save(ProductEntity productEntity);
    void delete(int id);
    Iterable<ProductEntity> findByCategoryid(int id);
}
