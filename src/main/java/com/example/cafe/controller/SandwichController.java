package com.example.cafe.controller;

import com.example.cafe.model.Drink;
import com.example.cafe.model.Sandwich;
import com.example.cafe.service.DrinkService;
import com.example.cafe.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/sandwich")
public class SandwichController {
    private final SandwichService sandwichService;
    @Autowired
    public SandwichController(SandwichService sandwichService){
        this.sandwichService=sandwichService;
    }


    @GetMapping(path="/getSandwiches")
    public List<Sandwich> getSandwiches(){
        return sandwichService.getSandwiches();
    }
    @PostMapping(path = "/addSandwich")
    public void saveDrink(@RequestBody Sandwich sandwich) {
        sandwichService.saveSandwich(sandwich);
    }
}
