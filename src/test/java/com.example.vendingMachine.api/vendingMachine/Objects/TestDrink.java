package com.example.vendingmachine.api;

import vendingMachine.Objects.Drink;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestDrink {

    @Test
    public void testCOKEhasName() {
      assertEquals( "coke", Drink.COKE.getName() );
    }

    @Test
    public void testCOKEhasPrice() {
      assertEquals( 0.65, Drink.COKE.getPrice() );
    }

    @Test
    public void testPEPSIhasName() {
      assertEquals( "pepsi", Drink.PEPSI.getName() );
    }

    @Test
    public void testPEPSIhasPrice() {
      assertEquals( 1.00, Drink.PEPSI.getPrice() );
    }

    @Test
    public void testSODAhasName() {
      assertEquals( "soda", Drink.SODA.getName() );
    }

    @Test
    public void testSODAhasPrice() {
      assertEquals( 1.50, Drink.SODA.getPrice() );
    }

    @Test
    public void testWATERhasName() {
      assertEquals( "water", Drink.WATER.getName() );
    }

    @Test
    public void testWATERhasPrice() {
      assertEquals( 2.00, Drink.WATER.getPrice() );
    }

    @Test
    public void testGetCOKEByName() {
      assertEquals( Drink.COKE, Drink.getDrinkByName("coke") );
    }

}
