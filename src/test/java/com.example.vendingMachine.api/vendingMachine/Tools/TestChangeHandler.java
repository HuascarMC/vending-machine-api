package com.example.vendingmachine.api;

import vendingMachine.Objects.ChangeHandler;
import vendingMachine.Objects.Coin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class TestChangeHandler {

    @Before
    public void before() {
     List<Coin> change = new ArrayList<>();
     change.add(Coin.QUARTER);
     change.add(Coin.DIME);
    }




}
