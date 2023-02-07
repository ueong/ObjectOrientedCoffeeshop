package com.example.objectorientedcoffeeshop.domain;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Barista {
    private final Map<Order, List<Drink>> madeDrinks = new HashMap<>();

    @SneakyThrows
    public void makeDrinkFor(Order order, Clerk clerk) {
        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(
                        () -> order.items().stream().flatMap(orderItem ->
                                IntStream.range(0, orderItem.quantity()).mapToObj(i -> {
                                    log.info("음료 제조 중 : " + orderItem.name() + " for " + order);
                                    return new Drink(orderItem.name());
                                })).collect(Collectors.toList()))
                .thenAccept(drinks -> {
                    this.madeDrinks.put(order, drinks);
                    clerk.onCompleted(order);
                });
        future.get();
    }

    public List<Drink> getDrinkFor(Order order) {
        List<Drink> drinksForOrder = madeDrinks.get(order);
        madeDrinks.remove(order);
        return drinksForOrder;
    }
}
