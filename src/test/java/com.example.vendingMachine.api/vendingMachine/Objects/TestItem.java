package com.example.vendingmachine.api;

import vendingMachine.Objects.Item;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestCoin {

    @Test
    public void testCOKEhasName() {
      assertEquals( "coke", Item.COKE.getName() );
    }

    @Test
    public void testCOKEhasPrice() {
      assertEquals( 0.65, Item.COKE.getPrice() );
    }

    @Test
    public void testPEPSIhasName() {
      assertEquals( "pepsi", Item.PEPSI.getName() );
    }

    @Test
    public void testPEPSIhasPrice() {
      assertEquals( 1.00, Item.PEPSI.getPrice() );
    }

    @Test
    public void testSODAhasName() {
      assertEquals( "soda", Item.SODA.getName() );
    }

    @Test
    public void testSODAhasPrice() {
      assertEquals( 1.50, Item.SODA.getPrice() );
    }

    @Test
    public void testWATERhasName() {
      assertEquals( "water", Item.WATER.getName() );
    }

    @Test
    public void testWATERhasPrice() {
      assertEquals( 2.00, Item.WATER.getPrice() );
    }

}
