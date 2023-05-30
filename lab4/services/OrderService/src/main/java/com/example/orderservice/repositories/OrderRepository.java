package com.example.orderservice.repositories;

import com.example.orderservice.OrderServiceApplication;
import com.example.orderservice.entities.Order;

import java.util.List;

public interface OrderRepository {
    void add(Order order);

    List<Order> getAll();

    Order getById(Long id);
}
