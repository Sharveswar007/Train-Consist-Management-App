public class TrainConsistManagementApp {

    // UC20: Search with state validation
    static boolean searchWithValidation(String[] bogieIDs, String searchKey) {

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
        System.out.println("UC20: Exception Handling During Search\n");

        System.out.println("--- Searching on Empty Consist ---");
        String[] emptyIDs = {};
        try {
            searchWithValidation(emptyIDs, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

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
