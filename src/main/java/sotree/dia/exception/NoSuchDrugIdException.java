package sotree.dia.exception;

public class NoSuchDrugIdException extends RuntimeException {
    public NoSuchDrugIdException() {
        super();
    }

    public NoSuchDrugIdException(String message) {
        super(message);
    }

    public NoSuchDrugIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchDrugIdException(Throwable cause) {
        super(cause);
    }
}
