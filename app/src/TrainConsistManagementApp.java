import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

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

    // This method is called by the test file
    static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC8: Filter Passenger Bogies Using Streams\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 18));
        bogies.add(new Bogie("Executive",   80));
        bogies.add(new Bogie("Economy",     48));

        System.out.println("All Bogies in Consist:");
        bogies.forEach(b -> System.out.println("  " + b));

        List<Bogie> filtered = filterBogiesByCapacity(bogies, 60);

        System.out.println("\nFiltered Bogies (capacity > 60):");
        if (filtered.isEmpty()) {
            System.out.println("  No bogies match the filter condition.");
        } else {
            filtered.forEach(b -> System.out.println("  " + b));
        }

        System.out.println("\nTotal bogies in consist : " + bogies.size());
        System.out.println("Bogies after filtering  : " + filtered.size());
        System.out.println("\nProgram continues...");
    }
}