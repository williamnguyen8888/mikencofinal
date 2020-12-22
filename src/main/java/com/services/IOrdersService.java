package com.services;

import com.models.OrdersEntity;

public interface IOrdersService {
    Iterable<OrdersEntity> findAll();
    OrdersEntity findById(int id);
    void save(OrdersEntity ordersEntity);
    void delete(int id);
}
