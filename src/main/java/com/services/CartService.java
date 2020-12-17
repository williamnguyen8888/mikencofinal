package com.services;

import com.models.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        Query query1 = entityManager.createNativeQuery("select LAST_INSERT_ID()");
         List<Integer> lastId = query1.getResultList();


        for (ProductEntity productCart : productEntities) {
            Query query2 = entityManager.createNativeQuery("INSERT INTO  orderdetail(orderId, productId, quantity)"
                    + " VALUES ( :d, :e, :f)");
            query2.setParameter("d", lastId.get(0));
            int productId = productCart.getProductId();
            query2.setParameter("e", productId);
            query2.setParameter("f", productCart.getQuantity());
            query2.executeUpdate();
        }
//        entityManager.getTransaction().commit();
//        entityManager.close();
    }

}
