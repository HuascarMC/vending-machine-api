package com.example.vendingmachine.api;

import vendingMachine.Objects.Order;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class TestOrder {

  private Order order;

  @Before
  public void before() {
    Order order = new Order("coke", 5);
  }

  @Test
  public void testOrderGetItem() {
    assertEquals( order.getItem(), "coke" );
  }

  @Test
  public void testOrderGetBalance() {
    assertEquals( order.getBalance(), 5 );
  }


}
