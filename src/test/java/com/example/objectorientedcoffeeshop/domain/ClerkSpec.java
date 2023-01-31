package com.example.objectorientedcoffeeshop.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ClerkSpec {
    @Test
    public void 점원은_손님이_주문을_하면_가격이_얼마인지_알려주고_돈을_내라고_한다() {
        List<Item> items = Arrays.asList(new Item("아메리카노", 1500),
                new Item("카페라떼", 2000),
                new Item("카페모카", 2500),
                new Item("유자차", 3500));
        Menu menuBoard = new Menu(items);
        Clerk clerk = new Clerk();
//        clerk.order()
    }
}
