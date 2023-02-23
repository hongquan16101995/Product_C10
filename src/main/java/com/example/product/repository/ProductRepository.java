package com.example.product.repository;

import com.example.product.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> findAll() {
        TypedQuery<Product> strQuery = entityManager.createNamedQuery("findAll", Product.class);
        return strQuery.getResultList();
    }

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public void create(Product product) {
        entityManager.persist(product);
    }

    public void update(Product product) {
        entityManager.merge(product);
    }


    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}
