import java.util.ArrayList;
import java.util.List;
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
    }

    // ─────────────────────────────────────────
    // UC13: Loop-based filtering
    // ─────────────────────────────────────────
    static List<Bogie> filterByLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // ─────────────────────────────────────────
    // UC13: Stream-based filtering
    // ─────────────────────────────────────────
    static List<Bogie> filterByStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    // ─────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC13: Performance Comparison\n");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            bogies.add(new Bogie("Bogie-" + i, 30 + (i % 80)));
        }
        System.out.println("Dataset size: " + bogies.size() + " bogies\n");

        // Loop-based benchmark
        long loopStart = System.nanoTime();
        List<Bogie> loopResult = filterByLoop(bogies, 60);
        long loopTime  = System.nanoTime() - loopStart;

        System.out.println("--- Loop-Based Filtering ---");
        System.out.println("Filtered bogies : " + loopResult.size());
        System.out.println("Execution Time  : " + loopTime + " ns");

        // Stream-based benchmark
        long streamStart = System.nanoTime();
        List<Bogie> streamResult = filterByStream(bogies, 60);
        long streamTime  = System.nanoTime() - streamStart;

        System.out.println("\n--- Stream-Based Filtering ---");
        System.out.println("Filtered bogies : " + streamResult.size());
        System.out.println("Execution Time  : " + streamTime + " ns");

        System.out.println("\n--- Comparison Summary ---");
        System.out.println("Results match : " +
                (loopResult.size() == streamResult.size()));
        System.out.println("Faster        : " +
                (loopTime < streamTime ? "Loop" : "Stream"));

        System.out.println("\nProgram continues...");
    }
}