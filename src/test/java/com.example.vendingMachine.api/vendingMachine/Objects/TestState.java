package com.example.vendingmachine.api;

import vendingMachine.Objects.State;
import vendingMachine.exceptions.NotEnoughBalanceException;
import vendingMachine.exceptions.OutOfStockException;
import vendingMachine.exceptions.NotEnoughChangeException;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class TestState {

    @Test
    public void testCoinInventoryStateOK() {
        State state = new State(true, true, true);
        assertEquals(state.getCoinInventoryState(), "OK");
    }

    @Test
    public void testStockInventoryStateOK() {
        State state = new State(true, true, true);
        assertEquals(state.getStockInventoryState(), "OK");
    }

    @Test
    public void testBalanceStateOK() {
        State state = new State(true, true, true);
        assertEquals(state.getBalanceState(), "OK");
    }

    @Test(expected = NotEnoughChangeException.class)
    public void testCoinInventoryStateNotOk() {
        State state = new State(true, false, true);
        assertEquals(state.getCoinInventoryState(), new NotEnoughChangeException());
    }

    @Test(expected = OutOfStockException.class)
    public void testStockInventoryStateNotOk() {
        State state = new State(false, true, true);
        assertEquals(state.getStockInventoryState(), new OutOfStockException());
    }

    @Test(expected = NotEnoughBalanceException.class)
    public void testBalanceStateNotOk() {
        State state = new State(true, true, false);
        assertEquals(state.getBalanceState(), new NotEnoughBalanceException());
    }

}
