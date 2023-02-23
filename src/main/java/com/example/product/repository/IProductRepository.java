package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByPriceBetween(Double price, Double price1);

    List<Product> findAllByNameContaining(String name);
}
