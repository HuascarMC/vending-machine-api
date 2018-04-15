package vendingMachine.Objects;

public class Order{

    private String item;
    private long balance;

    public Order(String item, long balance) {
        this.item = item;
        this.balance = balance;
    }

    public String getItem() {
        return item;
    }

    public long getBalance() {
        return balance;
    }
}
