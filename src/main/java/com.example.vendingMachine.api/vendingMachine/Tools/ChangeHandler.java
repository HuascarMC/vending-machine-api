package vendingMachine.Tools;

import vendingMachine.Objects.Coin;

import java.util.ArrayList;
import java.util.List;

public class ChangeHandler {

    public static float getChangeValue(List<Coin> change) {
        float totalValue = 0;
        for(Coin coin : change) {
            totalValue += coin.getValue();
        }
        return totalValue;
    }
}
//     public static List<Coin> convertToChange(double amount) {
//       List<Coin> changes = new ArrayList<>();
//       if(amount > 0) {
//           changes = new ArrayList<>();
//           // while the customers remaining amount is greater than 0, keep giving change.
//           while(amount > 0) {
//               // think of using modulus to give better change.
//               if(amount >= Coin.DOLLAR.getValue()) {
//                   changes.add(Coin.DOLLAR);
//                   amount = amount - Coin.DOLLAR.getValue();
//               } else if(amount >= Coin.QUARTER.getValue()) {
//                   changes.add(Coin.QUARTER);
//                   amount = amount - Coin.QUARTER.getValue();
//               } else if(amount >= Coin.DIME.getValue()) {
//                   changes.add(Coin.DIME);
//                   amount = amount - Coin.DIME.getValue();
//               } else if(amount >= Coin.NICKEL.getValue()) {
//                   changes.add(Coin.NICKEL);
//                   amount = amount - Coin.NICKEL.getValue();
//               } else {
//                   return changes;
//               }
//           }
//
//       }
//       return changes;
//   }
// }
