import org.junit.Test;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    // ══════════════════════════════════════════
    // TEST 1
    // Valid Train ID must return true
    // ══════════════════════════════════════════
    @Test
    public void testRegex_ValidTrainID() {

        assertTrue("TRN-1234 must be valid",
                TrainConsistManagementApp.validateTrainID("TRN-1234"));
    }

    // ══════════════════════════════════════════
    // TEST 2
    // Invalid Train ID formats must return false
    // ══════════════════════════════════════════
    @Test
    public void testRegex_InvalidTrainIDFormat() {

        assertFalse("TRAIN12 must be invalid",
                TrainConsistManagementApp.validateTrainID("TRAIN12"));

        assertFalse("TRN12A must be invalid",
                TrainConsistManagementApp.validateTrainID("TRN12A"));

        assertFalse("1234-TRN must be invalid",
                TrainConsistManagementApp.validateTrainID("1234-TRN"));
    }

    // ══════════════════════════════════════════
    // TEST 3
    // Valid Cargo Code must return true
    // ══════════════════════════════════════════
    @Test
    public void testRegex_ValidCargoCode() {

        assertTrue("PET-AB must be valid",
                TrainConsistManagementApp.validateCargoCode("PET-AB"));
    }

    // ══════════════════════════════════════════
    // TEST 4
    // Invalid Cargo Code formats must return false
    // ══════════════════════════════════════════
    @Test
    public void testRegex_InvalidCargoCodeFormat() {

        assertFalse("PET-ab must be invalid (lowercase)",
                TrainConsistManagementApp.validateCargoCode("PET-ab"));

        assertFalse("PET123 must be invalid",
                TrainConsistManagementApp.validateCargoCode("PET123"));

        assertFalse("AB-PET must be invalid",
                TrainConsistManagementApp.validateCargoCode("AB-PET"));
    }

    // ══════════════════════════════════════════
    // TEST 5
    // Train ID must have exactly 4 digits
    // ══════════════════════════════════════════
    @Test
    public void testRegex_TrainIDDigitLengthValidation() {

        assertFalse("TRN-123 must be invalid (only 3 digits)",
                TrainConsistManagementApp.validateTrainID("TRN-123"));

        assertFalse("TRN-12345 must be invalid (5 digits)",
                TrainConsistManagementApp.validateTrainID("TRN-12345"));
    }

    // ══════════════════════════════════════════
    // TEST 6
    // Cargo Code must accept only uppercase
    // ══════════════════════════════════════════
    @Test
    public void testRegex_CargoCodeUppercaseValidation() {

        assertFalse("PET-ab must be invalid (lowercase letters)",
                TrainConsistManagementApp.validateCargoCode("PET-ab"));

        assertFalse("PET-Ab must be invalid (mixed case)",
                TrainConsistManagementApp.validateCargoCode("PET-Ab"));
    }

    // ══════════════════════════════════════════
    // TEST 7
    // Empty input must return false for both
    // ══════════════════════════════════════════
    @Test
    public void testRegex_EmptyInputHandling() {

        assertFalse("Empty Train ID must be invalid",
                TrainConsistManagementApp.validateTrainID(""));

        assertFalse("Empty Cargo Code must be invalid",
                TrainConsistManagementApp.validateCargoCode(""));
    }

    // ══════════════════════════════════════════
    // TEST 8
    // Extra characters beyond pattern must fail
    // ══════════════════════════════════════════
    @Test
    public void testRegex_ExactPatternMatch() {

        assertFalse("TRN-1234X must be invalid (extra char)",
                TrainConsistManagementApp.validateTrainID("TRN-1234X"));

        assertFalse("PET-ABC must be invalid (3 letters)",
                TrainConsistManagementApp.validateCargoCode("PET-ABC"));
    }
}