package com.example.product.service.impl;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    private final List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<>();
        products.add(new Product(1L, "Coca", 7000d, 10));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        Product productUpdate = findById(product.getId());
        if (productUpdate != null) {
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setQuantity(product.getQuantity());
        }
    }

    @Override
    public void delete(Long id) {
        Product productDelete = findById(id);
        if (productDelete != null) {
            products.remove(productDelete);
        }
    }
}
