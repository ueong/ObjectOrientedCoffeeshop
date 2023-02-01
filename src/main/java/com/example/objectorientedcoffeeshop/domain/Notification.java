package com.example.objectorientedcoffeeshop.domain;

public class Notification {
    private final Customer customer;
    public Notification(Customer customer) {
        this.customer = customer;
    }

    public Customer customer() {
        return this.customer;
    }

    public void notifyCustomer(Clerk clerk) {
        this.customer.notified(clerk);
    }
}
