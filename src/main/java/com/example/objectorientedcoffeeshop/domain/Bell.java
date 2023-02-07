package com.example.objectorientedcoffeeshop.domain;

public class Bell {
    private final Customer customer;
    public Bell(Customer customer) {
        this.customer = customer;
    }

    public Customer customer() {
        return this.customer;
    }

    public void notifyCustomer(Clerk clerk) {
        this.customer.onDrinkReady(clerk);
    }
}
