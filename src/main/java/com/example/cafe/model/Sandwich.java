package com.example.cafe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Sandwich extends Item{
    public Sandwich(String name, int price) {
        super(name, price);
    }

    public Sandwich() {
    }
}
