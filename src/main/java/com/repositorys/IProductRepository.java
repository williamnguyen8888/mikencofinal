package com.repositorys;

import com.models.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface IProductRepository extends PagingAndSortingRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByPrice(double price, Pageable pageable);
}
