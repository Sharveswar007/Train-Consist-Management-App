import org.junit.Test;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    // ══════════════════════════════════════════
    // TEST 1
    // Valid capacity must create bogie
    // without any exception
    // ══════════════════════════════════════════
    @Test
    public void testException_ValidCapacityCreation() {

        try {
            TrainConsistManagementApp.PassengerBogie b =
                    new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

            assertEquals("Capacity must be 72", 72, b.capacity);
            assertEquals("Type must be Sleeper", "Sleeper", b.type);

        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            fail("No exception expected for valid capacity: " + e.getMessage());
        }
    }

    // ══════════════════════════════════════════
    // TEST 2
    // Negative capacity must throw
    // InvalidCapacityException
    // ══════════════════════════════════════════
    @Test
    public void testException_NegativeCapacityThrowsException() {

        try {
            new TrainConsistManagementApp.PassengerBogie("AC Chair", -10);
            fail("Exception expected for negative capacity");

        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            assertNotNull("Exception must be thrown", e);
        }
    }

    // ══════════════════════════════════════════
    // TEST 3
    // Zero capacity must throw
    // InvalidCapacityException
    // ══════════════════════════════════════════
    @Test
    public void testException_ZeroCapacityThrowsException() {

        try {
            new TrainConsistManagementApp.PassengerBogie("First Class", 0);
            fail("Exception expected for zero capacity");

        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            assertNotNull("Exception must be thrown for zero capacity", e);
        }
    }

    // ══════════════════════════════════════════
    // TEST 4
    // Exception message must match exactly
    // ══════════════════════════════════════════
    @Test
    public void testException_ExceptionMessageValidation() {

        try {
            new TrainConsistManagementApp.PassengerBogie("Sleeper", -5);
            fail("Exception expected");

        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            assertEquals("Exception message must match",
                    "Capacity must be greater than zero",
                    e.getMessage());
        }
    }

    // ══════════════════════════════════════════
    // TEST 5
    // Valid bogie must store correct
    // type and capacity values
    // ══════════════════════════════════════════
    @Test
    public void testException_ObjectIntegrityAfterCreation() {

        try {
            TrainConsistManagementApp.PassengerBogie b =
                    new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

            assertEquals("Type must be Sleeper", "Sleeper", b.type);
            assertEquals("Capacity must be 72",  72,        b.capacity);

        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            fail("No exception expected: " + e.getMessage());
        }
    }

    // ══════════════════════════════════════════
    // TEST 6
    // Multiple valid bogies must all be
    // created without exception
    // ══════════════════════════════════════════
    @Test
    public void testException_MultipleValidBogiesCreation() {

        try {
            new TrainConsistManagementApp.PassengerBogie("Sleeper",     72);
            new TrainConsistManagementApp.PassengerBogie("AC Chair",    56);
            new TrainConsistManagementApp.PassengerBogie("First Class", 18);

        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            fail("No exception expected for valid bogies: " + e.getMessage());
        }
    }
}