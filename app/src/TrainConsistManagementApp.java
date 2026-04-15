public class TrainConsistManagementApp {

    // UC17: Sort bogie names using Arrays.sort()
    static String[] sortBogieNames(String[] names) {
        String[] copy = Arrays.copyOf(names, names.length);
        Arrays.sort(copy);
        return copy;

public class TrainConsistManagementApp {

    // ─────────────────────────────────────────
    // UC16: Bubble Sort — manual sorting
    // No Arrays.sort() or Collections.sort()
    // ─────────────────────────────────────────
    static int[] bubbleSort(int[] capacities) {

        // Copy array to avoid modifying original
        int[] arr = Arrays.copyOf(capacities, capacities.length);
        int n = arr.length;

        // Outer loop — number of passes
        for (int i = 0; i < n - 1; i++) {

        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException(
                "Cannot search: Train consist is empty. Please add bogies before searching.");
        }

        for (String id : bogieIDs) {
            if (id.equals(searchKey)) {
                return true;
            }
        }
        return false;
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
        System.out.println("UC16: Sort Passenger Bogies by Capacity" +
                " (Bubble Sort)\n");

        // Step 1: Create array of bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Step 2: Display unsorted array
        System.out.println("Unsorted Capacities:");
        System.out.println("  " + Arrays.toString(capacities));

        // Step 3: Apply Bubble Sort
        int[] sorted = bubbleSort(capacities);

        // Step 4: Display sorted array
        System.out.println("\nSorted Capacities (Ascending):");
        System.out.println("  " + Arrays.toString(sorted));

        System.out.println("\n--- Searching on Valid Consist ---");
        String[] bogieIDs = {"BG101", "BG205", "BG309"};
        try {
            boolean found = searchWithValidation(bogieIDs, "BG205");
            System.out.println("Searching for BG205...");
            System.out.println("Result: " + (found ? "Bogie FOUND" : "Bogie NOT FOUND"));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Searching for Non-Existing Bogie ---");
        try {
            boolean found = searchWithValidation(bogieIDs, "BG999");
            System.out.println("Searching for BG999...");
            System.out.println("Result: " + (found ? "Bogie FOUND" : "Bogie NOT FOUND"));
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}
