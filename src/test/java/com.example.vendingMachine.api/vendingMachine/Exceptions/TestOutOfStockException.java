package com.example.vendingmachine.api;

import vendingMachine.exceptions.OutOfStockException;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import org.junit.Test;

public class TestOutOfStockException {

  @Test(expected=OutOfStockException.class)
  public void testOutOfStockException() {
    throw new OutOfStockException();
  }


  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testOutOfStockMessage() throws Exception {
    expectedEx.expect(RuntimeException.class);
    expectedEx.expectMessage("OutOfStock");
    throw new OutOfStockException();
  }
}
