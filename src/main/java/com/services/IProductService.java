package com.services;

import com.models.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Iterable<ProductEntity> findAll();
    Page<ProductEntity> finAll(Pageable pageable, int offset);
    ProductEntity finById(int id);
    void save(ProductEntity productEntity);
    void delete(int id);
    Iterable<ProductEntity> findByCategoryid(int id);
    Iterable<ProductEntity> findByRandomLimit5();

}
