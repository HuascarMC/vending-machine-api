package vendingMachine.exceptions;

public class NotEnoughChangeException extends RuntimeException {

    private String message;

    public NotEnoughChangeException() {
        this.message = "NotEnoughChange";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
