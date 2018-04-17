package com.example.vendingmachine.api;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import api.models.Coin;

public class TestCoinInventory {

  private Coin item = new Coin();

  @Before
  public void before() {
    item.setName("NICKEL");
    item.setQuantity(10);
  }

    @Test
    public void testName() {
        assertEquals( "NICKEL", item.getName());
    }

    @Test
    public void testQuantity() {
        assertEquals( Integer.valueOf(10), item.getQuantity());
    }

}
