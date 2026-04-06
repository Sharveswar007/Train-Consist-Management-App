import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC4: Maintain Ordered Bogie IDs using LinkedList");

        // Step 1: Create LinkedList to represent train consist
        LinkedList<String> consist = new LinkedList<>();

        // Step 2: Add bogies in sequence
        consist.addLast("Engine");
        consist.addLast("Sleeper");
        consist.addLast("AC");
        consist.addLast("Cargo");
        consist.addLast("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(consist);

        // Step 3: Insert Pantry Car at position 2
        consist.add(2, "Pantry Car");
        System.out.println("\nAfter inserting Pantry Car at position 2:");
        System.out.println(consist);

        // Step 4: Remove first and last bogie
        consist.removeFirst();
        consist.removeLast();
        System.out.println("\nAfter removing first (Engine) and last (Guard) bogie:");
        System.out.println(consist);

        System.out.println("\nFinal Train Consist Size: " + consist.size());
        System.out.println("Program continues...");
    }
}