package com.example.cafe.service;

import com.example.cafe.model.Drink;
import com.example.cafe.model.Item;
import com.example.cafe.repositories.DrinkRepository;
import com.example.cafe.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository, ItemRepository itemRepository) {
        this.drinkRepository = drinkRepository;
        this.itemRepository = itemRepository;
    }



    public List<Drink>  getDrinks(){
        return drinkRepository.findAll();
    }
    public List<Drink> getHotDrinks(){
        return drinkRepository.findByHot(true);
    }
    public List<Drink> getColdDrinks(){
        return drinkRepository.findByHot(false);
    }
    public void saveDrink(Drink drink) {
        drinkRepository.save(drink);
    }

}
