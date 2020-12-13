package com.services;

import com.models.ProductEntity;
import com.repositorys.IProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDetailService implements IProductDetailService {
    @Autowired
    private IProductDetailRepository iProductDetailRepository;

    @Override
    public Iterable<ProductEntity> findAll() {
        return iProductDetailRepository.findAll();
    }

    @Override
    public ProductEntity findById(int id) {
        return iProductDetailRepository.findOne(id);
    }

    @Override
    public void save(ProductEntity productEntity) {
        iProductDetailRepository.save(productEntity);
    }

    @Override
    public void delete(int id) {
        iProductDetailRepository.delete(id);
    }
}
