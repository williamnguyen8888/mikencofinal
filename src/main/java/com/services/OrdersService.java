package com.services;

import com.models.OrdersEntity;
import com.repositorys.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersService implements IOrdersService {

    @Autowired
    private IOrdersRepository iOrdersRepository;

    @Override
    public Iterable<OrdersEntity> findAll() {
        return iOrdersRepository.findAll();
    }

    @Override
    public OrdersEntity findById(int id) {
        return iOrdersRepository.findOne(id);
    }

    @Override
    public void save(OrdersEntity ordersEntity) {
        iOrdersRepository.save(ordersEntity);
    }

    @Override
    public void delete(int id) {
        iOrdersRepository.delete(id);
    }
}
