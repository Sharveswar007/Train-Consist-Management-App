import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainConsistManagementApp {

    // Inner class to model a Bogie object
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC7: Sort Bogies by Capacity using Comparator");

        // Step 1: Create List of Bogie objects
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 18));

        System.out.println("\nBogies before sorting:");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }

        // Step 2: Sort using Comparator by capacity (ascending)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nBogies after sorting by capacity (ascending):");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }

        // Step 3: Sort descending
        bogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());

        System.out.println("\nBogies after sorting by capacity (descending):");
        for (Bogie b : bogies) {
            System.out.println("  " + b);
        }

        System.out.println("\nProgram continues...");
    }
}