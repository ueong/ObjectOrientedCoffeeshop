package com.example.objectorientedcoffeeshop.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClerkSpec {
    @Test
    public void 점원은_손님의_주문을_받는다() {
        // given
        TestBarista barista = new TestBarista();
        Clerk clerk = new Clerk(barista);
        Menu menu = getMenu();
        Customer customer1 = new Customer();
        customer1.choose(menu, "아메리카노", 3);
        customer1.choose(menu, "카페모카", 2);
        customer1.choose(menu, "유자차", 1);

        // when
        Notification notification = clerk.order(customer1);

        // then
        assertEquals(customer1, notification.customer());
        assertEquals(customer1.myOrder(), barista.orders.get(0));
    }


    @Test
    public void 점원은_여러_손님의_주문을_받는다() {
        // given
        TestBarista barista = new TestBarista();
        Clerk clerk = new Clerk(barista);
        Menu menu = getMenu();

        Customer customer1 = new Customer();
        customer1.choose(menu, "아메리카노", 3);

        Customer customer2 = new Customer();
        customer2.choose(menu, "카페모카", 2);
        customer2.choose(menu, "유자차", 1);

        // when
        Notification notification1 = clerk.order(customer1);
        Notification notification2 = clerk.order(customer2);

        // then
        assertEquals(customer1, notification1.customer());
        assertEquals(customer2, notification2.customer());
        assertEquals(customer1.myOrder(), barista.orders.get(0));
        assertEquals(customer2.myOrder(), barista.orders.get(1));
    }

    private Menu getMenu() {
        List<Item> items = Arrays.asList(new Item("아메리카노", 1500),
                new Item("카페라떼", 2000),
                new Item("카페모카", 2500),
                new Item("유자차", 3500));
        return new Menu(items);
    }
    public static class TestBarista extends Barista {
        public List<Order> orders = new ArrayList<>();

        @Override
        public void makeDrinkFor(Order order, Clerk clerk) {
            this.orders.add(order);
        }
    }
}
