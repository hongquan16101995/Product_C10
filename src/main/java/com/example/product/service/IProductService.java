package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.service.core.ICoreService;

import java.util.List;

public interface IProductService extends ICoreService<Product> {
    List<Product> findByPrice(Double price, Double price1);

    List<Product> findByName(String name);
}
