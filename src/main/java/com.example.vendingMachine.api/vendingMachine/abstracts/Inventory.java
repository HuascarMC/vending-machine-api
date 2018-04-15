package com.vendingMachine.abstracts;

import com.vendingMachine.exceptions.OutOfStockException;

import java.util.HashMap;
import java.util.Map;

public abstract class Inventory<T> {

    private Map<T, Integer> inventory = new HashMap<>();

    public int getQuantity(T item) {
        // gets quantity value given a key.
        Integer value = inventory.get(item);
        return (value == null) ? 0 : value;
    }

    public void add(T item) {
        if (hasItem(item)) {
            int itemQuantity = inventory.get(item);
            inventory.put(item, itemQuantity + 1);
        } else {
            put(item, 1);
        }
    }

    public void remove(T item) {
        if (hasItem(item)) {
            int itemCount = inventory.get(item);
            inventory.put(item, itemCount - 1);
        }
    }

    public boolean hasItem(T item) throws OutOfStockException {
        return getQuantity(item) > 0;
    }

    public void clear() {
        inventory.clear();
    }

    public void put(T item, int quantity) {
        inventory.put(item, quantity);
    }

    public Map<T, Integer> getInventory() {
        return inventory;
    }
}
