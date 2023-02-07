package com.example.objectorientedcoffeeshop.domain;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private final Map<String, Item> menuItems = new HashMap<>();
    public Menu(@NonNull final List<Item> items) {
        items.forEach(item -> this.menuItems.put(item.name(), item));
    }

    public List<Item> show() {
        return new ArrayList<>(this.menuItems.values());
    }

    public Item find(String menuName) {
        return this.menuItems.get(menuName);
    }
}
