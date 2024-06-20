package apples.demo.exception;

public class NotEnoughApplesException extends RuntimeException {
    public NotEnoughApplesException(String message) {
        super(message);
    }
}