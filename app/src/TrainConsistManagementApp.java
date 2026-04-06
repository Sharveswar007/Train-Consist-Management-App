import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // ─────────────────────────────────────────
    // GoodsBogie class
    // ─────────────────────────────────────────
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type  = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " | Cargo: " + cargo;
        }
    }

    // ─────────────────────────────────────────
    // UC12: Safety compliance check
    // Rule: Cylindrical → only Petroleum allowed
    // ─────────────────────────────────────────
    static boolean isSafetyCompliant(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") ||
                        b.cargo.equals("Petroleum"));
    }

    // ─────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC12: Safety Compliance Check\n");

        // Safe formation
        List<GoodsBogie> safeBogies = new ArrayList<>();
        safeBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        safeBogies.add(new GoodsBogie("Rectangular", "Coal"));
        safeBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("Safe Formation:");
        safeBogies.forEach(b -> System.out.println("  " + b));
        System.out.println("Safety Compliant: " +
                isSafetyCompliant(safeBogies));

        // Unsafe formation
        List<GoodsBogie> unsafeBogies = new ArrayList<>();
        unsafeBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        unsafeBogies.add(new GoodsBogie("Cylindrical", "Coal")); // violation
        unsafeBogies.add(new GoodsBogie("Rectangular", "Grain"));

        System.out.println("\nUnsafe Formation:");
        unsafeBogies.forEach(b -> System.out.println("  " + b));
        System.out.println("Safety Compliant: " +
                isSafetyCompliant(unsafeBogies));

        System.out.println("\nProgram continues...");
    }
}