package com.example.hibernate2.model.repository;

import com.example.hibernate2.model.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    List<Product> findAllSortedByName();

    Product findById(Long id);

    void deleteById(Long id);

    void saveOrUpdate(Product product);
}
