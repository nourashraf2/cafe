package com.example.cafe.controller;

import com.example.cafe.model.Drink;
import com.example.cafe.model.Item;
import com.example.cafe.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/drink")
public class DrinkController {

    private final DrinkService drinkService;
    @Autowired
    public DrinkController(DrinkService drinkService){
        this.drinkService=drinkService;
    }

    @GetMapping(path="/getDrinks")
    public List<Drink> getDrinks(){
      return drinkService.getDrinks();
    }
    @GetMapping(path="/getHotDrinks")
    public List<Drink> getHotDrinks(){
        return drinkService.getHotDrinks();
    }
    @GetMapping(path="/getColdDrinks")
    public List<Drink> getColdDrinks(){
        return drinkService.getColdDrinks();
    }
    @PostMapping(path = "/addDrink")
    public void saveDrink(@RequestBody Drink drink) {
        drinkService.saveDrink(drink);
    }










}
