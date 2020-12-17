package com.services;

import com.models.ProductEntity;

import java.util.ArrayList;

public interface ICartService {
    void cartAddToDB(ArrayList<ProductEntity> productEntities, String idCustomer);
}
