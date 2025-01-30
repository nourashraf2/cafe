package com.example.cafe.controller;

import com.example.cafe.model.AddOn;
import com.example.cafe.model.Order;
import com.example.cafe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/addOrder")
    public void createOrder(@RequestBody Order order, @RequestParam List<Integer> itemIds) {
        orderService.saveOrder(order,itemIds);
    }
}
