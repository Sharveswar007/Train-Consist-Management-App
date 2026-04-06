import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC6: Map Bogie to Capacity using HashMap");

        // Step 1: Create HashMap to store bogie-capacity pairs
        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Step 2: Insert bogie-capacity mappings using put()
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 18);

        // Step 3: Display all entries using entrySet()
        System.out.println("\nBogie Capacity Mapping:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("  Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue() + " seats");
        }

        // Step 4: Fast lookup using key
        System.out.println("\nLookup Capacity for 'Sleeper': " +
                bogieCapacity.get("Sleeper") + " seats");

        System.out.println("Total bogie types mapped: " + bogieCapacity.size());

        System.out.println("\nProgram continues...");
    }
}