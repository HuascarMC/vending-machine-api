package vendingMachine.interfaces;

import vendingMachine.components.Bucket;

import vendingMachine.Objects.Coin;
import vendingMachine.Objects.State;
import vendingMachine.Objects.Order;

import java.util.List;

public interface Vendable {
    public Bucket<Enum, List<Coin>, State, Double> vend(Order order);
}
