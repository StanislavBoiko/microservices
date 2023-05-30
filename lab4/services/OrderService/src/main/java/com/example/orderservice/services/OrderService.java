package com.example.orderservice.services;

import com.example.orderservice.entities.Order;

import java.util.List;

public interface OrderService {
    void generate(int amount);

    List<Order> getAll();

    Order getById(Long id);
}
