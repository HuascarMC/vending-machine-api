package com.example.vendingmachine.api;

import vendingMachine.Tools.ChangeHandler;
import vendingMachine.Objects.Coin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class TestChangeHandler {

    List<Coin> change;

    @Before
    public void before() {
     List<Coin> change = new ArrayList<>();
     change.add(Coin.QUARTER);
     change.add(Coin.DIME);
    }

    @Test
    public void testConvertToChange() {
      assertEquals( this.change, ChangeHandler.convertToChange(0.35) );
    }

    @Test
    public void testAmountToChange() {
      assertEquals( 0.35, ChangeHandler.getChangeValue(this.change) );
    }

}
