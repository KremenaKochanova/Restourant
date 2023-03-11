package ProjectSystems.Restourant.Services;

public class TableNotFoundException extends RuntimeException {

    public TableNotFoundException(String message) {
        super("Масата не е намерена в базата данни");
    }

    public TableNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

