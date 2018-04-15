package com.example.vendingMachine.api;

import com.example.huascar.polymorphism.Objects.Coin;
import com.example.huascar.polymorphism.components.CoinInventory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCoinInventory {

  @Before
  public void before() {
    CoinInventory coinInventory = new CoinInventory();
  }

  @Test
  public void testEnoughChange() {
    CoinInventory coinInventory = new CoinInventory();
    coinInventory.add(Coin.NICKEL);
    assertEquals(coinInventory.enoughChange(1), true);
  }

  @Test
  public void testTotal() {
    CoinInventory coinInventory = new CoinInventory();
    coinInventory.put(Coin.QUARTER, 5);
    assertEquals(coinInventory.total(), 125);
  }
}