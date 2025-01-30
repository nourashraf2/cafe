package com.example.cafe.repositories;

import com.example.cafe.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {

    List<Drink> findByHot(boolean hot);
}
