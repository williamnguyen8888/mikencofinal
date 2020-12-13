package com.services;

import com.models.ProductEntity;

public interface IProductDetailService {
    Iterable<ProductEntity> findAll();
    ProductEntity findById(int id);
    void save(ProductEntity productEntity);
    void delete(int id);
}
