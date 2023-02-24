package com.example.product.formatter;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.format.Formatter;

import java.util.Locale;

public class ProductFormatter implements Formatter<Product> {

    private IProductService iProductService;

    public ProductFormatter(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @Override
    public Product parse(String text, Locale locale) {
        return iProductService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Product object, Locale locale) {
        return null;
    }
}
