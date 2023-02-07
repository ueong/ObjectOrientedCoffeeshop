package com.example.objectorientedcoffeeshop.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerSpec {
    @Test
    public void 손님은_메뉴를_고른다() {
        // given
        Menu menu = getMenu();
        Customer customer = new Customer();

        // when
        customer.choose(menu, "아메리카노", 3);
        customer.choose(menu, "카페모카", 2);
        customer.choose(menu, "유자차", 1);

        // then
        Order myOrder = customer.myOrder();
        assertEquals(6, myOrder.totalQuantities());
        assertEquals(13000, myOrder.totalPrice());
    }

    @Test
    public void 손님은_점원에게_주문을_한다() {
        // given
        OrderTestClerk clerk = new OrderTestClerk();
        Menu menu = getMenu();
        Customer customer = new Customer();
        customer.choose(menu, "아메리카노", 3);
        customer.choose(menu, "카페모카", 2);
        customer.choose(menu, "유자차", 1);

        // when
        customer.orderTo(clerk);

        // then
        assertTrue(clerk.isOrdered);
        assertEquals(customer, clerk.orderedCustomer);
    }

    @Test
    public void 손님은_점원에게_음료를_받아온다() {
        // given
        OrderTestClerk clerk = new OrderTestClerk();
        Menu menu = getMenu();
        Customer customer = new Customer();
        customer.choose(menu, "유자차", 1);
        customer.orderTo(clerk);

        // when
        customer.onDrinkReady(clerk);

        // then
        assertTrue(clerk.isDrinkDelivered);
    }

    private Menu getMenu() {
        Menu menu = new Menu(Arrays.asList(new Item("아메리카노", 1500),
                new Item("카페라떼", 2000),
                new Item("카페모카", 2500),
                new Item("유자차", 3500)));
        return menu;
    }

    public static class OrderTestClerk extends Clerk {
        public Customer orderedCustomer;
        public boolean isOrdered = false;
        public boolean isDrinkDelivered = false;

        public OrderTestClerk() {
            super();
        }

        @Override
        public Bell order(Customer customer) {
            this.isOrdered = true;
            this.orderedCustomer = customer;
            return new Bell(customer);
        }

        @Override
        public List<Drink> getDrinksFor(Customer customer) {
            this.isDrinkDelivered = true;
            return new ArrayList<>();
        }
    }
}
