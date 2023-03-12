package ProjectSystems.Restourant.Enum;

public enum OrderStatus {

    NEW("New"),
    COOKING("Cooking"),
    PREPARED("Prepared"),
    SERVED("Served"),
    PAID("Paid"),
    ACTIVE("isFree");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

