package vendingMachine.Objects;

import vendingMachine.exceptions.NotEnoughBalanceException;
import vendingMachine.exceptions.NotEnoughChangeException;
import vendingMachine.exceptions.OutOfStockException;

public class State {

  public boolean coinInventoryState;
  public boolean stockInventoryState;
  public boolean balanceState;
  public boolean successful;

  public State(boolean stockInventoryState, boolean coinInventoryState, boolean balanceState) {
    this.stockInventoryState = stockInventoryState;
    this.coinInventoryState = coinInventoryState;
    this.balanceState = balanceState;
    this.successful = this.possible();
  }
  public String getCoinInventoryState() {
    if(coinInventoryState) {
      return "OK";
    }
    throw new NotEnoughChangeException();
  }

  public String getStockInventoryState() {
    if(stockInventoryState) {
      return "OK";
    }
    throw new OutOfStockException();
  }

  public String getBalanceState() {
    if(balanceState) {
      return "OK";
    }
    throw new NotEnoughBalanceException();
  }

  public boolean possible() {
    return (coinInventoryState) && (stockInventoryState) && (balanceState);
  }
}
