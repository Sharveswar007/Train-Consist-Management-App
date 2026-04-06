public class TrainConsistManagementApp {

    // ─────────────────────────────────────────
    // UC14: Custom Checked Exception
    // ─────────────────────────────────────────
    static class InvalidCapacityException extends Exception {
        InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ─────────────────────────────────────────
    // PassengerBogie with capacity validation
    // ─────────────────────────────────────────
    static class PassengerBogie {
        String type;
        int    capacity;

        PassengerBogie(String type, int capacity)
                throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException(
                        "Capacity must be greater than zero");
            }
            this.type     = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (Capacity: " + capacity + ")";
        }
    }

    // ─────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC14: Handle Invalid Bogie Capacity\n");

        // Test 1: Valid creation
        System.out.println("--- Creating Valid Bogie ---");
        try {
            PassengerBogie b = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + b);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 2: Negative capacity
        System.out.println("\n--- Creating Bogie with Negative Capacity ---");
        try {
            new PassengerBogie("AC Chair", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Test 3: Zero capacity
        System.out.println("\n--- Creating Bogie with Zero Capacity ---");
        try {
            new PassengerBogie("First Class", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}