package com.example.vendingmachine.api;

import vendingMachine.exceptions.OutOfStockException;

import org.junit.Test;

public class TestOutOfStockException {

    @Test(expected=OutOfStockException.class)
    public void testOutOfStockException() {
        throw new OutOfStockException();
    }
}
