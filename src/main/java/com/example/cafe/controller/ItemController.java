package com.example.cafe.controller;

import com.example.cafe.model.AddOn;
import com.example.cafe.model.Drink;
import com.example.cafe.model.Item;
import com.example.cafe.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }


    @PostMapping(path = "/addItem")
    public void createItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }
    @GetMapping(path="/getItemsAddOn")
    public List<AddOn> getItemAddons( @RequestParam Integer itemId){
        return itemService.getItemAddOns(itemId);
    }
}
