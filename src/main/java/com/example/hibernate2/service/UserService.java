package com.example.hibernate2.service;

import com.example.hibernate2.model.entity.Product;
import com.example.hibernate2.model.entity.User;

public interface UserService {

    void detailsByUser(User user);

    void detailsByProduct(Product product);
}
