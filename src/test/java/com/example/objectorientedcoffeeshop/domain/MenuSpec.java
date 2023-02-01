package com.example.objectorientedcoffeeshop.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuSpec {
    @Test
    public void 아이템은_이름과_가격을_가지고_있다() {
        // when
        Item item = new Item("아메리카노", 1500);

        // then
        assertEquals("아메리카노", item.name());
        assertEquals(1500, item.price());
    }

    @Test
    public void 손님은_메뉴판을_확인할_수_있다() {
        // given
        List<Item> items = Arrays.asList(new Item("아메리카노", 1500),
                new Item("카페라떼", 2000),
                new Item("카페모카", 2500),
                new Item("유자차", 3500));

        // when
        Menu menu = new Menu(items);

        // then
        assertEquals(4, menu.show().size());
        assertEquals(items.get(0), menu.find("아메리카노"));
        assertEquals(items.get(3), menu.find("유자차"));
    }
}
