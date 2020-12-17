package com.services;

import com.models.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

public class CartService implements ICartService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void cartAddToDB(ArrayList<ProductEntity> productEntities, String idCustomer) {
//        entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("INSERT INTO  orders(customerID, dateOrdered, status)"
                    + " VALUES ( :a, :b, :c)");
            query.setParameter("a", idCustomer);
            query.setParameter("b", LocalDate.now());
            query.setParameter("c", "done");
            query.executeUpdate();
        for (ProductEntity productCart:productEntities) {
            Query query2 = entityManager.createNativeQuery("INSERT INTO  orderdetail(orderId, productId, quantity)"
                    + " VALUES ( last_insert_id(), :a, :b)");
            query2.setParameter("a",productCart.getProductId());
            query2.setParameter("b", productCart.getQuantity());
            query2.executeUpdate();
        }
//        entityManager.getTransaction().commit();
//        entityManager.close();
    }
}
