import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Step 1: Welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC3: Track Unique Bogie IDs using HashSet");

        // Step 2: Create a HashSet to store unique bogie IDs
        Set<String> bogieIDs = new HashSet<>();

        // Step 3: Add bogie IDs (including intentional duplicates)
        System.out.println("\nAdding bogie IDs to the train consist...");

        bogieIDs.add("BG101");
        System.out.println("Adding BG101...");

        bogieIDs.add("BG102");
        System.out.println("Adding BG102...");

        bogieIDs.add("BG103");
        System.out.println("Adding BG103...");

        bogieIDs.add("BG101"); // Duplicate
        System.out.println("Adding BG101 again (duplicate)...");

        bogieIDs.add("BG102"); // Duplicate
        System.out.println("Adding BG102 again (duplicate)...");

        bogieIDs.add("BG104");
        System.out.println("Adding BG104...");

        // Step 4: Display unique bogie IDs
        System.out.println("\nUnique Bogie IDs in Train Consist:");
        System.out.println(bogieIDs);

        // Step 5: Display total count
        System.out.println("\nTotal unique bogies registered: " + bogieIDs.size());

        // Step 6: Check if a specific bogie ID exists
        System.out.println("\nChecking bogie existence:");
        System.out.println("Contains BG101? " + bogieIDs.contains("BG101"));
        System.out.println("Contains BG105? " + bogieIDs.contains("BG105"));

        System.out.println("\nProgram continues...");
    }
}