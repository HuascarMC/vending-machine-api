package com.example.vendingmachine.api;

import vendingMachine.Exceptions.NotEnoughBalanceException;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class TestNotEnoughBalanceException {

    @Override(expected = NotEnoughBalanceException.class)
    public void testNotEnoughBalanceException() {
        throw new NotEnoughBalanceException();
    }
}
