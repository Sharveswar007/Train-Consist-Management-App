import java.util.Arrays;

public class TrainConsistManagementApp {

    // UC17: Sort bogie names using Arrays.sort()
    static String[] sortBogieNames(String[] names) {
        String[] copy = Arrays.copyOf(names, names.length);
        Arrays.sort(copy);
        return copy;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC17: Sort Bogie Names Using Arrays.sort()\n");

        String[] bogieNames = {
            "Sleeper", "AC Chair", "First Class",
            "General", "Luxury"
        };

        System.out.println("Unsorted Bogie Names:");
        System.out.println("  " + Arrays.toString(bogieNames));

        String[] sorted = sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println("  " + Arrays.toString(sorted));

        System.out.println("\nSorted Order:");
        for (int i = 0; i < sorted.length; i++) {
            System.out.println("  " + (i + 1) + ". " + sorted[i]);
        }

        System.out.println("\nOriginal array unchanged: " + Arrays.toString(bogieNames));
        System.out.println("\nProgram continues...");
    }
}
