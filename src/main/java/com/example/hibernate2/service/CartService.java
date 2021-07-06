package com.example.hibernate2.service;

import com.example.hibernate2.model.entity.Cart;
import com.example.hibernate2.model.entity.CartEntry;
import com.example.hibernate2.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    Cart getNewCart();

    void addProduct(Cart cart, Product product, Integer quantity);

    void addProduct(Cart cart, Long prodId, Integer quantity);

    BigDecimal getSum(Cart cart);

    Integer getItemsAmount(Cart cart);

    void printCart(Cart cart);

    int getProductQuantity(Cart cart, Product product);

    int getProductQuantity(Cart cart, Long prodId);

    List<Product> getCartListSorted(Cart cart);

    List<CartEntry> findAllProductsById(Long orderId);
}
