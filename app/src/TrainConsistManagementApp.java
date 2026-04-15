import java.util.Arrays;

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

            // Inner loop — compare adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {

                // Swap if left element is greater than right
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
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

        // Step 5: Show pass-by-pass trace
        System.out.println("\nPass-by-Pass Trace:");
        int[] trace = Arrays.copyOf(capacities, capacities.length);
        int n = trace.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (trace[j] > trace[j + 1]) {
                    int temp = trace[j];
                    trace[j] = trace[j + 1];
                    trace[j + 1] = temp;
                }
            }
            System.out.println("  After Pass " + (i + 1) + ": " +
                    Arrays.toString(trace));
        }

        System.out.println("\nOriginal array unchanged: " +
                Arrays.toString(capacities));
        System.out.println("\nProgram continues...");
    }
}
