package com.example.orderservice.services;

import com.example.orderservice.entities.*;
import com.example.orderservice.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final String productUrl = "http://product-service-service/api/product/ids";
    private final String userUrl = "http://user-service-service/api/user/ids";

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void generate(int amount) {
        RestTemplate template = new RestTemplate();
        List<Long> users = template.getForObject(userUrl, List.class);
        List<Long> products = template.getForObject(productUrl, List.class);

    }


    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }
}
