package ProjectSystems.Restourant.Services;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super("Order with id {id} not found");
    }
}

