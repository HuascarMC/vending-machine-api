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
