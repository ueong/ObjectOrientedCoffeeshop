package com.example.objectorientedcoffeeshop.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class OrderItem {
    private final Item item;
    private final int quantity;
    public OrderItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String name() {
        return this.item.name();
    }

    public int quantity() {
        return this.quantity;
    }

    public int price() {
        return this.item.price() * this.quantity;
    }
}
