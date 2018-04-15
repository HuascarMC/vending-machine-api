package vendingMachine.Objects;

import vendingMachine.exceptions.NotEnoughBalanceException;
import vendingMachine.exceptions.NotEnoughChangeException;
import vendingMachine.exceptions.OutOfStockException;

public class State {

    public boolean coinInventoryState;
    public boolean stockInventoryState;
    public boolean balanceState;

    public State(boolean coinInventoryState, boolean stockInventoryState, boolean balanceState) {
        this.coinInventoryState = coinInventoryState;
        this.stockInventoryState = stockInventoryState;
        this.balanceState = balanceState;
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
