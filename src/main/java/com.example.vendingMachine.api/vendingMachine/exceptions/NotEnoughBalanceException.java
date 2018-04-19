package vendingMachine.exceptions;

public class NotEnoughBalanceException extends RuntimeException {

    private String message;
    private long remaining;

    public NotEnoughBalanceException() {
        this.message = "NotEnoughBalance";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
