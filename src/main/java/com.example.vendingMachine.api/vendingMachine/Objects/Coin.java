package vendingMachine.Objects;

public enum Coin {
  PENNY("PENNY", 0.01), NICKEL("NICKEL", 0.05), DIME("DIME", 0.1), QUARTER("QUARTER", 0.25), DOLLAR("DOLLAR", 1.00);

  private String name;
  private double value;

  Coin(String name, double value) {
    this.name = name;
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}
