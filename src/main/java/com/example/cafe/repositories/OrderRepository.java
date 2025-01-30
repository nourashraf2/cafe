package com.example.cafe.repositories;

import com.example.cafe.model.Item;
import com.example.cafe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
