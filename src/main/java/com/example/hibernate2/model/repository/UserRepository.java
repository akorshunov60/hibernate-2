package com.example.hibernate2.model.repository;

import com.example.hibernate2.model.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findById(Long id);

    void deleteById(Long id);

    void saveOrUpdate(User user);
}
