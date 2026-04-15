import java.util.Arrays;

public class TrainConsistManagementApp {

    // UC19: Binary Search for Bogie ID
    static boolean binarySearch(String[] bogieIDs, String searchKey) {

        String[] sorted = Arrays.copyOf(bogieIDs, bogieIDs.length);
        Arrays.sort(sorted);

        int low = 0;
        int high = sorted.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = searchKey.compareTo(sorted[mid]);

            if (compare == 0) {
                return true;
            } else if (compare > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC19: Binary Search for Bogie ID\n");

        String[] bogieIDs = {
            "BG101", "BG205", "BG309", "BG412", "BG550"
        };

        System.out.println("Bogie IDs (Sorted):");
        for (String id : bogieIDs) {
            System.out.println("  " + id);
        }

        String search1 = "BG309";
        System.out.println("\nSearching for: " + search1);
        System.out.println("Result: " + (binarySearch(bogieIDs, search1) ? "Bogie FOUND" : "Bogie NOT FOUND"));

        String search2 = "BG999";
        System.out.println("\nSearching for: " + search2);
        System.out.println("Result: " + (binarySearch(bogieIDs, search2) ? "Bogie FOUND" : "Bogie NOT FOUND"));

        String search3 = "BG101";
        System.out.println("\nSearching for: " + search3);
        System.out.println("Result: " + (binarySearch(bogieIDs, search3) ? "Bogie FOUND" : "Bogie NOT FOUND"));

        String search4 = "BG550";
        System.out.println("\nSearching for: " + search4);
        System.out.println("Result: " + (binarySearch(bogieIDs, search4) ? "Bogie FOUND" : "Bogie NOT FOUND"));

        String[] unsorted = {
            "BG309", "BG101", "BG550", "BG205", "BG412"
        };
        System.out.println("\nUnsorted Input Test:");
        System.out.println("Searching BG205 in unsorted array...");
        System.out.println("Result: " + (binarySearch(unsorted, "BG205") ? "Bogie FOUND" : "Bogie NOT FOUND"));

        System.out.println("\nProgram continues...");
    }
}
