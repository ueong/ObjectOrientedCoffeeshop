package com.example.objectorientedcoffeeshop.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaristaSpec {
    @Test
    public void 바리스타는_음료를_만든다() {
        Barista barista = new Barista();
        TestClerk clerk = new TestClerk();
        Menu menu = new Menu(Arrays.asList(new Item("아메리카노", 1500),
                new Item("카페라떼", 2000),
                new Item("카페모카", 2500),
                new Item("유자차", 3500)));

        Order order = new Order();
        order.add(menu.find("아메리카노"), 3);
        order.add(menu.find("카페모카"), 2);
        order.add(menu.find("유자차"), 1);

        barista.makeDrinkFor(order, clerk);

        assertEquals(clerk.order, order);

    }

    @Test
    public void 바리스타는_음료를_내어준다() {
        Barista barista = new Barista();
        TestClerk clerk = new TestClerk();
        Menu menu = new Menu(Arrays.asList(new Item("아메리카노", 1500),
                new Item("카페라떼", 2000),
                new Item("카페모카", 2500),
                new Item("유자차", 3500)));

        Order order = new Order();
        order.add(menu.find("아메리카노"), 3);
        order.add(menu.find("카페모카"), 2);
        order.add(menu.find("유자차"), 1);

        barista.makeDrinkFor(order, clerk);

        List<Drink> madeDrinkForOrder = barista.getDrinkFor(order);
        assertEquals(6, madeDrinkForOrder.size());

    }

    public static class TestClerk extends Clerk {
        public Order order = null;

        public TestClerk() {
            super();
        }

        @Override
        public void onCompleted(Order order) {
            this.order = order;
        }
    }
}
