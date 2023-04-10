package ProjectSystems.Restourant.Enum;

public enum DrinkType {

    BEVERAGE ("Напитки");


    private final String value;

    private DrinkType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
