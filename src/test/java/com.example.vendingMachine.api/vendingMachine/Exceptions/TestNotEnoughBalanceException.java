package com.example.vendingmachine.api;

import vendingMachine.exceptions.NotEnoughBalanceException;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TestNotEnoughBalanceException {

    @Test(expected=NotEnoughBalanceException.class)
    public void testNotEnoughBalanceException() {
        throw new NotEnoughBalanceException();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testNotEnoughBalanceMessage() throws Exception {
      expectedEx.expect(RuntimeException.class);
      expectedEx.expectMessage("NotEnoughBalance");
      throw new NotEnoughBalanceException();
  }
}
