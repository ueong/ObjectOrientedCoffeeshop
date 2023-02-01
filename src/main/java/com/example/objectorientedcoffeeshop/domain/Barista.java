package com.example.objectorientedcoffeeshop.domain;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Barista {
    @SneakyThrows
    public void makeDrinkFor(Order order, Clerk clerk) {
        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(
                        () -> order.items().stream().flatMap(orderItem ->
                                IntStream.range(0, orderItem.quantity()).mapToObj(i -> makeDrink(order, orderItem))).collect(Collectors.toList()))
                .thenAccept(drinks -> clerk.take(drinks, order));
       future.get();
    }

    @SneakyThrows
    private Drink makeDrink(Order order, OrderItem orderItem) {
        log.info("음료 제조 중 : " + orderItem.name() + " for " + order.id());
        TimeUnit.MILLISECONDS.sleep(100);
        return new Drink(orderItem.name());
    }
}
