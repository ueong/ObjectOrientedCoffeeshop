package com.example.objectorientedcoffeeshop.domain;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode
public class Customer {
    private final Order myOrder;

    public Customer() {
        this.myOrder = new Order();
    }

    public void choose(Menu menu, String menuName, int quantity) {
        this.myOrder.add(menu.find(menuName), quantity);
    }

    public Order myOrder() {
        return this.myOrder;
    }

    public void orderTo(Clerk clerk) {
        clerk.order(this);
    }

    public void onDrinkReady(Clerk clerk) {
        List<Drink> drinks = takeDrinkFrom(clerk);
        drinks.forEach(Drink::taste);
    }

    private List<Drink> takeDrinkFrom(Clerk clerk) {
        return clerk.getDrinksFor(this);
    }

}
