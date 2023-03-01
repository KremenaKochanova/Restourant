package ProjectSystems.Restourant.Services;

   public class OrderAlreadyExistsException extends RuntimeException {
    public OrderAlreadyExistsException(String message) {
            super(message);
        }
    }
