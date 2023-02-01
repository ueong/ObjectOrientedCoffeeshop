package com.example.objectorientedcoffeeshop.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
public class Customer {
    private final CustomerId id;
    private final Order myOrder;

    public Customer() {
        this.id = new CustomerId();
        this.myOrder = new Order();
    }
    public CustomerId id() {
        return this.id;
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

    public void notified(Clerk clerk) {
        List<Drink> drinks = takeDrinkFrom(clerk);
        drinks.stream().forEach(drink -> drink.taste());
    }

    private List<Drink> takeDrinkFrom(Clerk clerk) {
        return clerk.deliverOrderedDrinks(this);
    }

}
