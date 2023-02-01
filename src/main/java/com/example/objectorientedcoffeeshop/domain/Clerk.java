package com.example.objectorientedcoffeeshop.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clerk {
//    private final Map<Customer, Order> orders = new HashMap<>();
    private final Map<Order, Notification> notifications = new HashMap<>();
    private final Map<Order, List<Drink>> madeDrinks = new HashMap<>();
    private final Barista barista;

    public Clerk() {
        this(new Barista());
    }
    public Clerk(Barista barista) {
        this.barista = barista;
    }

    public Notification order(Customer customer) {
//        this.orders.put(customer, customer.myOrder());
        barista.makeDrinkFor(customer.myOrder(), this);
        final Notification notification = new Notification(customer);
        notifications.put(customer.myOrder(), notification);
        return notification;
    }

    public void take(List<Drink> drinks, Order order) {
        madeDrinks.put(order, drinks);
        notifications.get(order).notifyCustomer(this);
    }

    public List<Drink> deliverOrderedDrinks(Customer customer) {
        return madeDrinks.get(customer.myOrder());
    }
}
