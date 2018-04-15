package com.example.vendingmachine.api;

import vendingMachine.exceptions.NotEnoughBalanceException;

import org.junit.Test;

public class TestNotEnoughBalanceException {

    @Test(expected=NotEnoughBalanceException.class)
    public void testNotEnoughBalanceException() {
        throw new NotEnoughBalanceException();
    }
}
