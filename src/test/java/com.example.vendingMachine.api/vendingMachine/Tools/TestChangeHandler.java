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

    // @Test
    // public void testConvertToChange() {
    //   assertEquals( this.change, ChangeHandler.convertToChange(0.35) );
    // }

    @Test
    public void testGetChangeValue() {
      assertEquals( 0.35, (float) ChangeHandler.getChangeValue(this.change), 0.003 );
    }

}
