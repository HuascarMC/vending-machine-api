package com.example.vendingmachine.api;

import vendingMachine.components.Bucket;

import vendingMachine.Objects.Drink;
import vendingMachine.Objects.Coin;
import vendingMachine.Objects.State;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

public class TestBucket {

  @Test
  public void testBucketHasFirst() {
    Bucket bucket = new Bucket(false, true, true);
    assertFalse( (boolean) bucket.getFirst() );
  }

  @Test
  public void testBucketHasSecond() {
    Bucket bucket = new Bucket(true, false, true);
    assertFalse( (boolean) bucket.getSecond() );
  }

  @Test
  public void testBucketHasThird() {
    Bucket bucket = new Bucket(true, true, false);
    assertFalse( (boolean) bucket.getThird() );
  }

  @Test
  public void testBucketHasFourth() {
    Bucket bucket = new Bucket(true, true, true, false);
    assertFalse( (boolean) bucket.getFourth() );
  }

}
