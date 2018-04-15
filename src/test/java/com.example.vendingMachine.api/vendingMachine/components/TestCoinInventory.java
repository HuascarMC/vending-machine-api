package com.example.vendingMachine.api;

import vendingMachine.Objects.Coin;
import vendingMachine.components.CoinInventory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

public class TestCoinInventory {

  private CoinInventory coinInventory;

  @Before
  public void before() {
    coinInventory = new CoinInventory();
  }

  @Test
  public void testUpdate() {
    coinInventory.add(Coin.DIME);
    List<Coin> change = new ArrayList<>();
    change.add(Coin.DIME);
    coinInventory.update(change);
    assertFalse( coinInventory.hasItem(Coin.DIME) );
  }

  @Test
  public void testEnoughChange() {
    coinInventory.add(Coin.NICKEL);
    assertEquals(coinInventory.enoughChange(0.05), true);
  }

  @Test
  public void testTotal() {
    coinInventory.put(Coin.QUARTER, 5);
    assertEquals(coinInventory.total(), 1.25, 0.003);
  }
}
