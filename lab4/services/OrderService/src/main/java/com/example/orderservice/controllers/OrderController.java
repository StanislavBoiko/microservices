package com.example.orderservice.controllers;

import com.example.orderservice.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @GetMapping("order")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("order/generate")
    public ResponseEntity generateOrder(){
        orderService.generate(1);
        return ResponseEntity.ok().build();
    }
}
