package vendingMachine.abstracts;

import vendingMachine.components.StockInventory;
import vendingMachine.components.CoinInventory;
import vendingMachine.components.Bucket;

import vendingMachine.interfaces.Vendable;
import vendingMachine.interfaces.Resetable;

import vendingMachine.Objects.Coin;
import vendingMachine.Objects.State;
import vendingMachine.Objects.Order;

import java.util.List;

public abstract class VendingMachine implements Vendable, Resetable {

  private CoinInventory coinInventory;
  private StockInventory stockInventory;

  public VendingMachine() {
    coinInventory = new CoinInventory();
    stockInventory = new StockInventory();
  }


  public void reset() {
    coinInventory.clear();
    stockInventory.clear();
  }
}
