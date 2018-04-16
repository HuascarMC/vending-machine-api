package vendingMachine.Tools;

import vendingMachine.Objects.Coin;
import vendingMachine.exceptions.NotEnoughChangeException;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ChangeHandler {

    public static float getChangeValue(List<Coin> change) {
        float totalValue = 0;
        for(Coin coin : change) {
            totalValue += coin.getValue();
        }
        return totalValue;
    }

    public static List<Coin> convertToChange(double amount) {
      BigDecimal amountDecimal = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
      List<Coin> changes = new ArrayList<>();

      if(amountDecimal.compareTo(BigDecimal.ZERO) > 0) {
          // while the customers remaining amount is greater than 0, keep giving change.
          while(amountDecimal.compareTo(BigDecimal.ZERO) > 0) {
              // think of using modulus to give better change.
              if( (amountDecimal.compareTo(new BigDecimal(Coin.DOLLAR.getValue())) == 1) || (amountDecimal.compareTo(new BigDecimal(Coin.DOLLAR.getValue()).setScale(2, RoundingMode.HALF_UP)) == 0 ))  {
                  changes.add( Coin.DOLLAR );
                  amountDecimal = amountDecimal.subtract(new BigDecimal(Coin.DOLLAR.getValue()));

              } else if( (amountDecimal.compareTo(new BigDecimal(Coin.QUARTER.getValue())) == 1) || (amountDecimal.compareTo(new BigDecimal(Coin.QUARTER.getValue()).setScale(2, RoundingMode.HALF_UP)) == 0 )) {
                changes.add( Coin.QUARTER );
                amountDecimal = amountDecimal.subtract(new BigDecimal(Coin.QUARTER.getValue()));

              } else if( (amountDecimal.compareTo(new BigDecimal(Coin.DIME.getValue())) == 1) || (amountDecimal.compareTo(new BigDecimal(Coin.DIME.getValue()).setScale(1, RoundingMode.HALF_UP)) ==  0 )) {
                  changes.add( Coin.DIME );
                  amountDecimal = amountDecimal.subtract(new BigDecimal(Coin.DIME.getValue()));

              } else if( (amountDecimal.compareTo(new BigDecimal(Coin.NICKEL.getValue())) == 1) || (amountDecimal.compareTo(new BigDecimal(Coin.NICKEL.getValue()).setScale(2, RoundingMode.HALF_UP)) ==  0 )){
                  changes.add( Coin.NICKEL );
                  amountDecimal = amountDecimal.subtract(new BigDecimal(Coin.NICKEL.getValue()).setScale(2, RoundingMode.HALF_UP) );
              } else {
                // Dunno why without this exception the method gets stuck or returns the wrong change.
                throw new NotEnoughChangeException();
              }
          }

      }
      return changes;
  }

  public static double subtractPrice(double balance, double price) {
    double result = balance - price;
    BigDecimal resultDecimal = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
    double preciseResult = resultDecimal.doubleValue();
    return preciseResult;
  }
}
