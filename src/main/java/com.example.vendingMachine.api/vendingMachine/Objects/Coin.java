package vendingMachine.Objects;

public enum Coin {
  PENNY(0.01), NICKEL(0.05), DIME(0.1), QUARTER(0.25), DOLLAR(1.00);

  private double value;

  Coin(double value) {
    this.value = value;
  }

  public double getValue() {
    return value;
  }
}
