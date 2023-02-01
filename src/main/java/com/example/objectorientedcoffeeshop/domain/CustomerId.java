package com.example.objectorientedcoffeeshop.domain;


import com.example.objectorientedcoffeeshop.domain.id.Id;
import com.example.objectorientedcoffeeshop.domain.id.IdGenerator;
import com.example.objectorientedcoffeeshop.domain.id.RandomUUIDStringIdGenerator;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@EqualsAndHashCode
public class CustomerId implements Id<String> {
    private final String value;

    public CustomerId() {
        this(new RandomUUIDStringIdGenerator());
    }
    public CustomerId(IdGenerator<String> idGenerator) {
        this.value = idGenerator.next();
    }

    @Override
    public String value() {
        return this.value;
    }
}
