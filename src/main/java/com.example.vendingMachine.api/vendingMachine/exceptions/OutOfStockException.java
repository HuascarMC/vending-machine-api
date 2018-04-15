package vendingMachine.exceptions;

public class OutOfStockException extends RuntimeException {

    private String message;

    public OutOfStockException() {
        this.message = "OutOfStockException";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
