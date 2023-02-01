package com.example.objectorientedcoffeeshop.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
public class Order {
    private OrderId id;
    private final List<OrderItem> orderItems = new ArrayList<>();
    public Order() {
        this.id = new OrderId();
    }

    public void add(Item item, int quantity) {
        this.orderItems.add(new OrderItem(item, quantity));
    }

    public int totalQuantities() {
        return this.orderItems.stream().mapToInt(OrderItem::quantity).sum();
    }

    public int totalPrice() {
        return this.orderItems.stream().mapToInt(OrderItem::price).sum();
    }

    public List<OrderItem> items() {
        return this.orderItems;
    }

    public OrderId id() {
        return this.id;
    }
}
