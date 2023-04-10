package ProjectSystems.Restourant.Enum;

public enum Role {

        WAITER("Сервитьор"),
        COOK("Готвач");

        private final String value;

        private Role(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

