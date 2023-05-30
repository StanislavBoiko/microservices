package com.example.orderservice.repositories;

import com.example.orderservice.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private List<Order> list = new ArrayList<>();
    @Override
    public void add(Order order) {
        list.add(order);
    }

    @Override
    public List<Order> getAll() {
        return list;
    }

    @Override
    public Order getById(Long id) {
        return list.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
