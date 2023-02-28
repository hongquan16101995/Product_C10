package com.example.product.service.impl;

import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import com.example.product.repository.ProductRepository;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

//    @Autowired
//    private ProductRepository productRepository;

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Product product) throws InputMismatchException {
        iProductRepository.save(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public List<Product> findByPrice(Double price, Double price1) {
        return iProductRepository.findAllByPriceBetween(price, price1);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName("%" + name + "%");
    }
}
