package com.example.vendingMachine.api;

import vendingMachine.components.CoinInventory;
import vendingMachine.components.Bucket;
import vendingMachine.components.StockInventory;

import vendingMachine.Objects.Order;
import vendingMachine.Objects.Coin;
import vendingMachine.Objects.Drink;
import vendingMachine.Objects.State;

import vendingMachine.DrinkVendingMachine;

import org.junit.Before;
import org.junit.Test;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import junit.framework.Assert;

public class TestDrinkVendingMachine {

  private Order cokeOrderChange;
  private Order pepsiOrderNoChange;
  private Order sodaOrderOutStock;
  private Order cokeOrderOutBalance;
  private Order sodaOrderOutChange;

  private DrinkVendingMachine vendingMachine;

  @Before
  public void before() {
    vendingMachine = new DrinkVendingMachine();
    vendingMachine.initialize();

    cokeOrderChange = new Order("coke", 1);
    pepsiOrderNoChange = new Order("pepsi", 1);
    sodaOrderOutStock = new Order("coke", 2);
    cokeOrderOutBalance = new Order("coke", 0);
    sodaOrderOutChange = new Order("coke", 50);
  }

  @Test
  public void testVendWithChange() {
    Bucket result = vendingMachine.vend(cokeOrderChange);

    List<Coin> change = new ArrayList<>();
    change.add(Coin.QUARTER);
    change.add(Coin.DIME);

    State state = new State(true, true, true);

    Bucket expectedResult = new Bucket<>(Drink.COKE, change, state);

    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getFirst(), expectedResult.getFirst() ));
    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getSecond(), expectedResult.getSecond() ));
    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getThird(), expectedResult.getThird() ));
  }

  @Test
  public void testVendWithNoChange() {
    Bucket result = vendingMachine.vend(pepsiOrderNoChange);

    List<Coin> change = new ArrayList<>();

    State state = new State(true, true, true);

    Bucket expectedResult = new Bucket<>(Drink.PEPSI, change, state);

    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getFirst(), expectedResult.getFirst() ));
    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getSecond(), expectedResult.getSecond() ));
    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getThird(), expectedResult.getThird() ));
  }

  @Test
  public void testNoVendNoStock() {
    vendingMachine.vend(sodaOrderOutStock);
    vendingMachine.vend(sodaOrderOutStock);
    vendingMachine.vend(sodaOrderOutStock);
    vendingMachine.vend(sodaOrderOutStock);
    vendingMachine.vend(sodaOrderOutStock);
    Bucket result = vendingMachine.vend(sodaOrderOutStock);


    List<Coin> change = new ArrayList<>();
    change.add(Coin.DOLLAR);
    change.add(Coin.DOLLAR);

    State state = new State(false, true, true);

    Bucket expectedResult = new Bucket<>(null, change, state);

    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getFirst(), expectedResult.getFirst() ));
    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getSecond(), expectedResult.getSecond() ));
    Assert.assertTrue(EqualsBuilder.reflectionEquals( result.getThird(), expectedResult.getThird() ));
  }

  // @Test
  // public void testVendNotEnoughBalance() {
  //   Bucket result = vendingMachine.vend(cokeOrderOutBalance);
  // }
  //
  // @Test
  // public void testVendNotEnoughChange() {
  //   Bucket result = vendingMachine.vend(sodaOrderOutChange);
  // }
}
