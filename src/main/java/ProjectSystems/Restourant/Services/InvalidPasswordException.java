package ProjectSystems.Restourant.Services;

public class InvalidPasswordException extends Throwable {

        public InvalidPasswordException(String message) {
            super(message);
        }

        public InvalidPasswordException(String message, Throwable cause) {
            super(message, cause);
        }

    }

