package com.example.vendingmachine.api;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import api.models.Item;

public class TestItem {

  private Item item = new Item();

  @Before
  public void before() {
    item.setName("soda");
    item.setQuantity(1);
  }

    @Test
    public void testName() {
        assertEquals( "soda", item.getName());
    }

    @Test
    public void testQuantityIn() {
        assertEquals( Integer.valueOf(1), item.getQuantity());
    }

}
