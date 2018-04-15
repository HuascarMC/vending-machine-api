package com.example.vendingmachine.api;

import vendingMachine.Objects.Item;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestCoin {

    @Test
    public void testCOKEhasName() {
      assertEquals( "coke", Item.COKE.getName());
    }

    @Test
    public void testCOKEhasPrice() {
      assertEquals( "0.65", Item.COKE.getPrice());
    }


}
