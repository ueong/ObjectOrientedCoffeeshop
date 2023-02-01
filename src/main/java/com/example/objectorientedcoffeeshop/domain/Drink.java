package com.example.objectorientedcoffeeshop.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Drink {
    private final String name;

    public Drink(String name) {
        this.name = name;
    }

    void taste() {
        log.info("taste : " + this.name);
    }
}
