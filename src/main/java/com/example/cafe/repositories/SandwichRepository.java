package com.example.cafe.repositories;

import com.example.cafe.model.Drink;
import com.example.cafe.model.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich, Integer> {
}
