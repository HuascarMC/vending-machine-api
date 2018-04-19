package vendingMachine.components;

import vendingMachine.Objects.Coin;
import vendingMachine.abstracts.Inventory;

import vendingMachine.exceptions.NotEnoughChangeException;

import java.util.List;
import java.util.Map;

public class CoinInventory extends Inventory<Coin> {

  public void update(List<Coin> change) {
    for(Coin coin : change) {
      this.remove(coin);
    }
  }

  public double total() {
    double total = 0;
    for(Map.Entry<Coin, Integer> entry: this.getInventory().entrySet()) {
      Coin coin = entry.getKey();
      Integer quantity = entry.getValue();
      total += coin.getValue() * quantity;
    }
    return total;
  }

  public boolean enoughChange(double balance) {
    return this.total() >= balance;
  }

}
