package com.repositorys;

import com.models.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IOrdersRepository extends CrudRepository<OrdersEntity,Integer> {

}
