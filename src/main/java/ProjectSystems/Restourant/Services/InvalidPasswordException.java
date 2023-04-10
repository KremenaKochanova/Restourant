package ProjectSystems.Restourant.Services;

public class InvalidPasswordException extends Throwable {

        public InvalidPasswordException(String message) {
            super("The password is incorrect");
        }

    }

