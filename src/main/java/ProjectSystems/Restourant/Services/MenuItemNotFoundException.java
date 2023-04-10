package ProjectSystems.Restourant.Services;

public class MenuItemNotFoundException extends MenuException {
    private static String message = "The wrong";

    public MenuItemNotFoundException(String s) {
        super(message="The Item not found");
    }
}
