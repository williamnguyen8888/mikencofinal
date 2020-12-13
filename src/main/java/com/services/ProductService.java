package com.services;


import com.models.ProductEntity;
import com.repositorys.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Iterable<ProductEntity> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public ProductEntity finById(int id) {
        return iProductRepository.findOne(id);
    }

    @Override
    public void save(ProductEntity productEntity) {
        iProductRepository.save(productEntity);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }

    @Override
    public Iterable<ProductEntity> findByCategoryid(int id) {
        Query query = entityManager.createQuery(
                "SELECT a FROM ProductEntity a WHERE a.categoryId = ?1 ");
        query.setParameter(1,id);

        List<ProductEntity> ProductEntity = query.getResultList();
        if (ProductEntity.isEmpty()){
            return null;
        }
        return ProductEntity;
    }


}
