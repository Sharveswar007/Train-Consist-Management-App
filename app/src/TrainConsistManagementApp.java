public class TrainConsistManagementApp {

    // UC18: Linear Search for Bogie ID
    static boolean linearSearch(String[] bogieIDs, String searchKey) {
        for (String id : bogieIDs) {
            if (id.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC18: Linear Search for Bogie ID\n");

        String[] bogieIDs = {
            "BG101", "BG205", "BG309", "BG412", "BG550"
        };

        System.out.println("Bogie IDs in Consist:");
        for (String id : bogieIDs) {
            System.out.println("  " + id);
        }

        String search1 = "BG309";
        System.out.println("\nSearching for: " + search1);
        boolean found1 = linearSearch(bogieIDs, search1);
        System.out.println("Result: " + (found1 ? "Bogie FOUND" : "Bogie NOT FOUND"));

        String search2 = "BG999";
        System.out.println("\nSearching for: " + search2);
        boolean found2 = linearSearch(bogieIDs, search2);
        System.out.println("Result: " + (found2 ? "Bogie FOUND" : "Bogie NOT FOUND"));

        String search3 = "BG101";
        System.out.println("\nSearching for: " + search3);
        boolean found3 = linearSearch(bogieIDs, search3);
        System.out.println("Result: " + (found3 ? "Bogie FOUND" : "Bogie NOT FOUND"));

        String search4 = "BG550";
        System.out.println("\nSearching for: " + search4);
        boolean found4 = linearSearch(bogieIDs, search4);
        System.out.println("Result: " + (found4 ? "Bogie FOUND" : "Bogie NOT FOUND"));

        System.out.println("\nProgram continues...");
    }
}
