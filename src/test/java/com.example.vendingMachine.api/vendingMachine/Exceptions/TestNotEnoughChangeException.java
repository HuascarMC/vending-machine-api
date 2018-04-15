package com.example.vendingmachine.api;

import vendingMachine.exceptions.NotEnoughChangeException;

import org.junit.Test;

public class TestNotEnoughChangeException {

    @Test(expected=NotEnoughChangeException.class)
    public void testNotEnoughChangeException() {
        throw new NotEnoughChangeException();
    }
}
