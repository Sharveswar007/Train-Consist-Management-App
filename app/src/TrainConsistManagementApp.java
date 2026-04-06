import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    // UC9: Group bogies by type
    // ─────────────────────────────────────────
    static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    // ─────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC9: Group Bogies by Type\n");

        // Step 1: Create list with multiple bogies of same type
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("Sleeper",     70));
        bogies.add(new Bogie("First Class", 18));
        bogies.add(new Bogie("AC Chair",    60));
        bogies.add(new Bogie("First Class", 20));

        // Step 2: Display all bogies
        System.out.println("All Bogies:");
        bogies.forEach(b -> System.out.println("  " + b));

        // Step 3: Group bogies by type
        Map<String, List<Bogie>> grouped = groupBogiesByType(bogies);

        // Step 4: Display grouped result
        System.out.println("\nGrouped Bogies by Type:");
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("\n  Type  : " + entry.getKey());
            System.out.println("  Count : " + entry.getValue().size());
            entry.getValue().forEach(b ->
                    System.out.println("    -> " + b));
        }

        // Step 5: Summary
        System.out.println("\nTotal bogie types found  : " + grouped.size());
        System.out.println("Original list unchanged  : " + (bogies.size() == 6));
        System.out.println("\nProgram continues...");
    }
}