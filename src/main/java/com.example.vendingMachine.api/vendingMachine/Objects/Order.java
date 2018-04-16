package vendingMachine.Objects;

public class Order{

    private String item;
    private double balance;

    public Order(String item, double balance) {
        this.item = item;
        this.balance = balance;
    }

    public String getItem() {
        return item;
    }

    public double getBalance() {
        return balance;
    }
}
