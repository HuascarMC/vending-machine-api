package com.example.vendingmachine.api;

import vendingMachine.exceptions.NotEnoughChangeException;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TestNotEnoughChangeException {

    @Test(expected=NotEnoughChangeException.class)
    public void testNotEnoughChangeException() {
        throw new NotEnoughChangeException();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testNotEnoughChangeMessage() throws Exception {
      expectedEx.expect(RuntimeException.class);
      expectedEx.expectMessage("NotEnoughChange");
      throw new NotEnoughChangeException();
  }
}
