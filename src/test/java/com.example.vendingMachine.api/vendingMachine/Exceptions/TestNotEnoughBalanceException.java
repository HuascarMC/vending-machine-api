package com.example.vendingmachine.api;

import vendingMachine.exceptions.NotEnoughBalanceException;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class TestNotEnoughBalanceException {

    @Test(expected=NotEnoughBalanceException.class)
    public void testNotEnoughBalanceException() {
        throw new NotEnoughBalanceException();
    }
}
