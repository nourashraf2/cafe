package com.example.cafe.repositories;

import com.example.cafe.model.AddOn;
import com.example.cafe.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
