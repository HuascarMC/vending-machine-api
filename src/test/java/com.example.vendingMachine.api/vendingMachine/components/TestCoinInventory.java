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
  public void testEnoughChangeCase2() {
    coinInventory.add(Coin.DOLLAR);
    coinInventory.add(Coin.DOLLAR);
    assertEquals(coinInventory.enoughChange(2), true);
  }

  @Test
  public void testTotal() {
    coinInventory.put(Coin.QUARTER, 5);
    assertEquals(coinInventory.total(), 1.25, 0.003);
  }

  @Test
  public void testEnoughChangeCase3() {
    coinInventory.put(Coin.DOLLAR, 5);
    coinInventory.put(Coin.QUARTER, 5);
    coinInventory.put(Coin.DIME, 5);
    coinInventory.put(Coin.NICKEL, 5);
    coinInventory.put(Coin.PENNY, 5);
    assertEquals(coinInventory.enoughChange(1.67), true);
  }

  @Test
  public void testTotalCase2() {
    coinInventory.put(Coin.DOLLAR, 5);
    coinInventory.put(Coin.QUARTER, 5);
    coinInventory.put(Coin.DIME, 5);
    coinInventory.put(Coin.NICKEL, 5);
    coinInventory.put(Coin.PENNY, 5);
    assertEquals(coinInventory.total(), 7.05, 0.003);
  }
}
