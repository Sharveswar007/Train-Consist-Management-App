import java.util.ArrayList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Step 1: Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Step 2: Create an ArrayList to store passenger bogies
        ArrayList<String> passengerBogies = new ArrayList<>();

        // Step 3: Add bogies using add()
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Step 4: Display bogies after insertion
        System.out.println("\nPassenger Bogies after addition:");
        System.out.println(passengerBogies);
        System.out.println("Total bogies: " + passengerBogies.size());

        // Step 5: Remove a bogie using remove()
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing 'AC Chair':");
        System.out.println(passengerBogies);

        // Step 6: Check existence using contains()
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("\nDoes consist contain 'Sleeper'? " + hasSleeper);

        boolean hasACChair = passengerBogies.contains("AC Chair");
        System.out.println("Does consist contain 'AC Chair'? " + hasACChair);

        // Step 7: Print final list state
        System.out.println("\nFinal Passenger Bogie Consist:");
        System.out.println(passengerBogies);
        System.out.println("Total bogies in consist: " + passengerBogies.size());

        System.out.println("\nProgram continues...");
    }
}