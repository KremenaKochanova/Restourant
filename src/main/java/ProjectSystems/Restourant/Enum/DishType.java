package ProjectSystems.Restourant.Enum;

public enum DishType {
    SALAD("Салати"),
    SOUP("Супи"),
    MAIN_DISH("Основно"),
    DESSERT("Десерти");


    private final String value;

    private DishType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
