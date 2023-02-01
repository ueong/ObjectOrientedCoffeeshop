package com.example.objectorientedcoffeeshop.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerSpec {
    @Test
    public void 손님은_자신의_고유_ID를_가지고_있다() {
        // when
        Customer customer = new Customer();

        // then
        assertNotNull(customer.id());
    }

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

        public OrderTestClerk() {
            super();
        }

        @Override
        public Notification order(Customer customer) {
            this.isOrdered = true;
            this.orderedCustomer = customer;
            return new Notification(customer);
        }
    }
}
