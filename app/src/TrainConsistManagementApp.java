import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC5: Preserve Insertion Order using LinkedHashSet");

        // Step 1: Create LinkedHashSet for train formation
        Set<String> formation = new LinkedHashSet<>();

        // Step 2: Add bogies in order
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        System.out.println("\nTrain Formation after initial attachment:");
        System.out.println(formation);

        // Step 3: Attempt to add duplicate
        System.out.println("\nAttempting to attach 'Sleeper' again (duplicate)...");
        boolean added = formation.add("Sleeper");
        System.out.println("Was duplicate added? " + added);

        // Step 4: Display final formation
        System.out.println("\nFinal Train Formation (insertion order preserved):");
        System.out.println(formation);
        System.out.println("Total bogies: " + formation.size());

        System.out.println("\nProgram continues...");
    }
}