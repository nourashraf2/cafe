package com.example.cafe.service;

import com.example.cafe.model.AddOn;
import com.example.cafe.model.Drink;
import com.example.cafe.model.Item;
import com.example.cafe.repositories.AddOnRepository;
import com.example.cafe.repositories.DrinkRepository;
import com.example.cafe.repositories.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddOnService {

    private final AddOnRepository addOnRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public AddOnService(AddOnRepository addOnRepository, ItemRepository itemRepository) {
        this.addOnRepository = addOnRepository;
        this.itemRepository = itemRepository;
    }



    public List<AddOn> getAddOns(){
        return addOnRepository.findAll();
    }

    public void saveAddOn(AddOn addOn,List<Integer> itemIds) {
        for(Integer i :itemIds){
            Item item = itemRepository.findById(i)
                    .orElseThrow(() -> new EntityNotFoundException("Item not found with ID: " + i));
            addOn.addItem(item);
            addOnRepository.save(addOn);
        }

    }






}