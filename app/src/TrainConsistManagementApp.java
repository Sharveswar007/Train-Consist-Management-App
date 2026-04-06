import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    // ─────────────────────────────────────────
    // UC11: Validate Train ID format
    // Valid format → TRN-1234 (4 digits only)
    // ─────────────────────────────────────────
    static boolean validateTrainID(String trainID) {
        Pattern pattern = Pattern.compile("TRN-\\d{4}");
        Matcher matcher = pattern.matcher(trainID);
        return matcher.matches();
    }

    // ─────────────────────────────────────────
    // UC11: Validate Cargo Code format
    // Valid format → PET-AB (2 uppercase only)
    // ─────────────────────────────────────────
    static boolean validateCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    // ─────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC11: Validate Train ID & Cargo Codes\n");

        // Train ID tests
        String[] trainIDs = {
                "TRN-1234", "TRAIN12", "TRN12A",
                "1234-TRN", "TRN-123", "TRN-12345"
        };

        System.out.println("--- Train ID Validation (Pattern: TRN-XXXX) ---");
        for (String id : trainIDs) {
            System.out.println("  " + id + " --> " +
                    (validateTrainID(id) ? "VALID" : "INVALID"));
        }

        // Cargo Code tests
        String[] cargoCodes = {
                "PET-AB", "PET-ab", "PET123",
                "AB-PET", "PET-A",  "PET-ABC"
        };

        System.out.println("\n--- Cargo Code Validation (Pattern: PET-XX) ---");
        for (String code : cargoCodes) {
            System.out.println("  " + code + " --> " +
                    (validateCargoCode(code) ? "VALID" : "INVALID"));
        }

        System.out.println("\nProgram continues...");
    }
}