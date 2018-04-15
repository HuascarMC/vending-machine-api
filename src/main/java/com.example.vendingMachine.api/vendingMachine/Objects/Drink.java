package vendingMachine.Objects;

public enum Drink {
    COKE("coke", 0.65), PEPSI("pepsi", 1.00), SODA("soda", 1.50), WATER("water", 2.00);

    private String name;
    private double price;

    Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
