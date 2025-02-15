package com.example.cafe.service;

import com.example.cafe.model.AddOn;
import com.example.cafe.model.Item;
import com.example.cafe.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public void saveItem(Item item) {
        itemRepository.save(item);
    }
    
    public List<AddOn> getItemAddOns(int id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            return item.getAddOns();
        } else {
            return Collections.emptyList();
        }
    }






}
