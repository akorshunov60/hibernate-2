package com.example.hibernate2.service;

import com.example.hibernate2.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    void saveOrUpdate(Product product);

    Product getProductById(Long id);

    void deleteById(Long id);
}

