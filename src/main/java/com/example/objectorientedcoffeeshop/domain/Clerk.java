package com.example.objectorientedcoffeeshop.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clerk {
    private final Map<Order, Bell> bells = new HashMap<>();
    private final Map<Order, List<Drink>> madeDrinks = new HashMap<>();
    private final Barista barista;

    public Clerk() {
        this(new Barista());
    }
    public Clerk(Barista barista) {
        this.barista = barista;
    }

    public Bell order(Customer customer) {
        Bell bell = prepareBellFor(customer);
        barista.makeDrinkFor(customer.myOrder(), this);
        return bell;
    }

    private Bell prepareBellFor(Customer customer) {
        final Bell bell = new Bell(customer);
        bells.put(customer.myOrder(), bell);
        return bell;
    }

    public List<Drink> getDrinksFor(Customer customer) {
        return madeDrinks.get(customer.myOrder());
    }

    public void onCompleted(Order order) {
        List<Drink> drinksForOrder = barista.getDrinkFor(order);
        madeDrinks.put(order, drinksForOrder);
        bells.get(order).notifyCustomer(this);
    }
}
