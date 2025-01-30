package com.example.cafe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Drink extends Item{
    boolean withMilk;
    boolean hot;
    Size size;
    public Drink(String name, int price, boolean withMilk, boolean hot,Size size) {
        super(name, price);
        this.withMilk = withMilk;
        this.hot = hot;
        this.size=size;
    }

    public Drink() {
        super();
    }

    public void setWithMilk(boolean withMilk) {
        this.withMilk = withMilk;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isWithMilk() {
        return withMilk;
    }

    public boolean isHot() {
        return hot;
    }

    @Override
    public String toString() {
        return super.toString() +"Drink{" +
                "withMilk=" + withMilk +
                ", hot=" + hot +
                ", size=" + size +
                "} " ;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
