package ProjectSystems.Restourant.Services;

public class TableOccupiedException extends RuntimeException {
    public TableOccupiedException(String message) {
        super("Тази маса е вече заета от друга поръчка. Моля, изберете друга маса или изчакайте да бъде освободена.");
    }
}

