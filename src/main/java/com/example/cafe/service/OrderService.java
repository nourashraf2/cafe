package com.example.cafe.service;

import com.example.cafe.model.AddOn;
import com.example.cafe.model.Item;
import com.example.cafe.model.Order;
import com.example.cafe.repositories.ItemRepository;
import com.example.cafe.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public void saveOrder(Order order, List<Integer> itemIds) {


        for (Integer i : itemIds) {
            Item item = itemRepository.findById(i)
                    .orElseThrow(() -> new EntityNotFoundException("Item not found with ID: " + i));
            order.addItem(item);

        }
        orderRepository.save(order);

    }
}
