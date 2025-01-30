package com.example.cafe.service;

import com.example.cafe.model.Drink;
import com.example.cafe.model.Sandwich;
import com.example.cafe.repositories.DrinkRepository;
import com.example.cafe.repositories.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichService {

    private final SandwichRepository sandwichRepository;

    @Autowired
    public SandwichService(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }


    public List<Sandwich> getSandwiches(){
        return sandwichRepository.findAll();
    }
    public void saveSandwich(Sandwich sandwich) {
        sandwichRepository.save(sandwich);
    }
}
