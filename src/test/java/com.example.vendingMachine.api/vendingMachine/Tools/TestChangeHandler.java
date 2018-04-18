package com.example.vendingmachine.api;

import vendingMachine.Tools.ChangeHandler;
import vendingMachine.Objects.Coin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class TestChangeHandler {

    private List<Coin> change;

    @Before
    public void before() {
     this.change = new ArrayList<>();
     this.change.add(Coin.QUARTER);
     this.change.add(Coin.DIME);

    }

    @Test
    public void testConvertToChange() {
      assertEquals( this.change, ChangeHandler.convertToChange(0.35) );
    }

    @Test
    public void testGetChangeValue() {
      assertEquals( 0.35, (double) ChangeHandler.getChangeValue(this.change), 0.003 );
    }

    @Test
    public void testSubtractPrice() {
      assertEquals( 0.35, (double) ChangeHandler.subtractPrice(1, 0.65) );
    }

    @Test
    public void testConvertToChange2() {
      List<Coin> change2 = new ArrayList();
      change2.add(Coin.DOLLAR);
      change2.add(Coin.QUARTER);
      change2.add(Coin.QUARTER);
      change2.add(Coin.DIME);
      change2.add(Coin.NICKEL);
      change2.add(Coin.PENNY);
      change2.add(Coin.PENNY);
      assertEquals( change2, ChangeHandler.convertToChange(1.67) );
    }

}
