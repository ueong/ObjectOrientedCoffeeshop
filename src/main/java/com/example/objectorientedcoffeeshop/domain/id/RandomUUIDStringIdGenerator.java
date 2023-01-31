package com.example.objectorientedcoffeeshop.domain.id;

import java.util.UUID;

public class RandomUUIDStringIdGenerator implements IdGenerator<String> {
    @Override
    public String next() {
        return UUID.randomUUID().toString();
    }
}
