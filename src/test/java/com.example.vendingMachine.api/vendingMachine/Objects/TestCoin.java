package com.example.vendingmachine.api;

import com.example.vendingmachine.api.vendingMachine.Objects.Coin;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestCoin {

    @Test
    public void testNickelValue() {
        assertEquals( 0.05, Coin.NICKEL.getValue());
    }

    @Test
    public void testDimeValue() {
        assertEquals( 0.10, Coin.DIME.getValue());
    }

    @Test
    public void testDimeGetValue() {
        assertEquals(0.25, Coin.QUARTER.getValue());
    }

    @Test
    public void testQuarterGetValue() {
        assertEquals(1.00, Coin.DOLLAR.getValue());
    }

}
