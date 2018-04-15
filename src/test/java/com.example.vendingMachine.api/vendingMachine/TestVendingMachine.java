// package com.example.vendingMachine.api;
//
// import vendingMachine.Objects.Coin;
// import vendingMachine.Objects.Order;
// import vendingMachine.components.CoinInventory;
// import vendingMachine.components.Bucket;
// import vendingMachine.components.StockInventory;
// import vendingMachine.Objects.Drink;
// import vendingMachine.State;
//
// import org.junit.Before;
// import org.junit.Test;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import static junit.framework.Assert.assertEquals;
// import static junit.framework.Assert.assertSame;
// import static junit.framework.Assert.assertTrue;
//
// public class TestVendingMachine {
//
//   private Order cokeOrderChange;
//   private Order pepsiOrderNoChange;
//   private Order sodaOrderOutStock;
//   private Order cokeOrderOutBalance;
//   private Order sodaOrderOutChange;
//
//   private VendingMachine vendingMachine;
//
//   @Before
//   public void before() {
//     vendingMachine = new VendingMachine();
//
//     cokeOrderChange = new Order("coke", 5);
//     pepsiOrderNoChange = new Order("coke", 1);
//     sodaOrderOutStock = new Order("coke", 5);
//     cokeOrderOutBalance = new Order("coke", 0);
//     sodaOrderOutChange = new Order("coke", 50);
//   }
//
//   @Test
//   public void testVendWithChange() {
//     Bucket result = vendingMachine.vend(cokeOrderChange);
//   }
//
//   @Test
//   public void testVendWithNoChange() {
//     Bucket result = vendingMachine.vend(pepsiOrderNoChange);
//   }
//
//   @Test
//   public void testVendNoStock() {
//     Bucket result = vendingMachine.vend(sodaOrderOutStock);
//   }
//
//   @Test
//   public void testVendNotEnoughBalance() {
//     Bucket result = vendingMachine.vend(cokeOrderOutBalance);
//   }
//
//   @Test
//   public void testVendNotEnoughChange() {
//     Bucket result = vendingMachine.vend(sodaOrderOutChange);
//   }
// }
