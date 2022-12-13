package sotree.dia.exception;

public class NoSuchDrugIdException extends RuntimeException {
    private String nedrugUrl;

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

    public NoSuchDrugIdException(Throwable cause, String nedrugUrl) {
        super(cause);
        this.nedrugUrl = nedrugUrl;
    }

    public String getNedrugUrl() {
        return nedrugUrl;
    }
}
