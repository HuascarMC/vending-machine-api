// package vendingMachine;
//
// import vendingMachine.components.Bucket;
// import vendingMachine.components.CoinInventory;
// import vendingMachine.components.StockInventory;
//
// import vendingMachine.abstracts.VendingMachine;
//
// import vendingMachine.Objects.State;
// import vendingMachine.Objects.Coin;
// import vendingMachine.Objects.Drink;
// import vendingMachine.Objects.Order;
//
// import vendingMachine.Tools.ChangeHandler;
//
// import java.util.List;
//
// public class DrinkVendingMachine extends VendingMachine {
//
//   public DrinkVendingMachine() {
//     super();
//     initialize();
//   }
//
//   private void initialize() {
//     // Adds 5 coins of each coin enum type.
//     for(Coin coin : Coin.values()) {
//       coinInventory.put(coin, 5);
//     }
//     // Adds 5 drinks of each drink enum type.
//     for(Drink drink: Drink.values()) {
//       stockInventory.put(drink ,5);
//     }
//   }
//
//   @Override
//   public Bucket<Drink, List<Coin>, State> vend(Order order) {
//     Drink drink = (Drink) Drink.getDrinkByName((String) order.getFirst());
//     long balance =  order.getSecond();
//
//     long remainingBalance = balance -= drink.getPrice();
//
//     State state = new State(stockInventory.hasDrink(drink), coinInventory.enoughChange(remainingBalance), remainingBalance >= 0 );
//
//     if(state.possible()) {
//       stockInventory.remove(drink);
//       List<Coin> change = ChangeHandler.convertToChange(remainingBalance);
//       coinInventory.update(change);
//       return new Bucket<>(drink, change, state);
//     }
//     List<Coin> refund = ChangeHandler.convertToChange(balance);
//     return new Bucket<>(null, refund, state);
//   }
// }
