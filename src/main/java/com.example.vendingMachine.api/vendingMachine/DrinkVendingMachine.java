package vendingMachine;

import vendingMachine.components.Bucket;
import vendingMachine.components.CoinInventory;
import vendingMachine.components.StockInventory;

import vendingMachine.abstracts.VendingMachine;

import vendingMachine.Objects.State;
import vendingMachine.Objects.Coin;
import vendingMachine.Objects.Drink;
import vendingMachine.Objects.Order;

import vendingMachine.Tools.ChangeHandler;

import java.util.List;

public class DrinkVendingMachine extends VendingMachine {

  public DrinkVendingMachine() {
    super();
  }

  @Override
    public Bucket<Enum, List<Coin>, State> vend(Order order) {
    Drink drink = (Drink) Drink.getDrinkByName((String) order.getItem());
    long balance =  order.getBalance();

    long remainingBalance = balance -= drink.getPrice();

    State state = new State(stockInventory.hasItem(drink), coinInventory.enoughChange(remainingBalance), remainingBalance >= 0 );

    if(state.possible()) {
      stockInventory.remove(drink);
      List<Coin> change = ChangeHandler.convertToChange(remainingBalance);
      coinInventory.update(change);
      return new Bucket<>(drink, change, state);
    }
    List<Coin> refund = ChangeHandler.convertToChange(balance);
    return new Bucket<>(null, refund, state);
  }
}
