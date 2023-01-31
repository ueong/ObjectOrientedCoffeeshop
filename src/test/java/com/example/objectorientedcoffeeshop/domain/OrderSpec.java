package com.example.objectorientedcoffeeshop.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderSpec {
    @Test
    public void 주문_아이템은_아이템과_수량을_가지고_있다() {
        OrderItem orderItem = new OrderItem(new Item("아메리카노", 1500), 3);
        assertEquals("아메리카노", orderItem.name());
        assertEquals(3, orderItem.quantity());
        assertEquals(4500, orderItem.price());
    }

    @Test
    public void 주문은_주문번호를_가지고_있다() {
        Menu menu = new Menu(Arrays.asList(new Item("아메리카노", 1500),
                new Item("카페라떼", 2000),
                new Item("카페모카", 2500),
                new Item("유자차", 3500)));
        Order order = new Order(menu);
        assertNotNull(order.id());
        System.out.println("주문번호 : " + order.id());

    }
    @Test
    public void 손님은_메뉴판을_보고_주문을_생성한다() {
        Menu menu = new Menu(Arrays.asList(new Item("아메리카노", 1500),
                new Item("카페라떼", 2000),
                new Item("카페모카", 2500),
                new Item("유자차", 3500)));

        Order order = new Order(menu);
        order.add("아메리카노", 3);
        order.add("카페모카", 2);
        order.add("유자차", 1);

        assertEquals(6, order.totalQuantities());
        assertEquals(13000, order.totalPrice());
        assertEquals(3, order.items().size());
    }
}
