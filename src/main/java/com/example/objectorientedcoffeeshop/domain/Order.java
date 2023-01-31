package com.example.objectorientedcoffeeshop.domain;

import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Order {
    private OrderId id;
    private final Menu menu;
    private final List<OrderItem> orderItems = new ArrayList<>();
    public Order(@NonNull final Menu menu) {
        this.id = new OrderId();
        this.menu = menu;
    }

    public void add(String menuName, int quantity) {
        this.orderItems.add(new OrderItem(menu.find(menuName), quantity));
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
