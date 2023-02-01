package com.example.objectorientedcoffeeshop.domain;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
public class Item {
    private final String name;
    private final int price;
    public Item(@NonNull final String name, @NonNull int price) {
        this.name = name;
        this.price = price;
    }

    public String name() {
        return this.name;
    }

    public int price() {
        return this.price;
    }
}
