import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // ─────────────────────────────────────────
    // Bogie class
    // ─────────────────────────────────────────
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name     = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    // ─────────────────────────────────────────
    // UC10: Total seating capacity using reduce
    // ─────────────────────────────────────────
    static int totalSeatingCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    // ─────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC10: Count Total Seats using reduce()\n");

        // Step 1: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 18));

        // Step 2: Display all bogies
        System.out.println("Bogies in Train:");
        bogies.forEach(b -> System.out.println("  " + b));

        // Step 3: Calculate total using map + reduce
        int total = totalSeatingCapacity(bogies);

        // Step 4: Display result
        System.out.println("\nTotal Seating Capacity : " + total + " seats");
        System.out.println("Total bogies in consist: " + bogies.size());
        System.out.println("Original list unchanged: " + (bogies.size() == 3));

        System.out.println("\nProgram continues...");
    }
}