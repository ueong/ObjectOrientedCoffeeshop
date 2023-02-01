package com.example.objectorientedcoffeeshop.domain;


import com.example.objectorientedcoffeeshop.domain.id.Id;
import com.example.objectorientedcoffeeshop.domain.id.IdGenerator;
import com.example.objectorientedcoffeeshop.domain.id.RandomUUIDStringIdGenerator;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class OrderId implements Id<String> {
    private final String value;

    public OrderId() {
        this(new RandomUUIDStringIdGenerator());
    }
    public OrderId(IdGenerator<String> idGenerator) {
        this.value = idGenerator.next();
    }

    @Override
    public String value() {
        return this.value;
    }
}
