package com.example.objectorientedcoffeeshop.domain.id;

public interface IdGenerator<T> {
    T next();
}
