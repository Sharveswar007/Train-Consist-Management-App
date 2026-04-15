import org.junit.Test;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testSearch_ThrowsExceptionWhenEmpty() {

        String[] empty = {};

        try {
            TrainConsistManagementApp.searchWithValidation(empty, "BG101");
            fail("IllegalStateException expected for empty array");
        } catch (IllegalStateException e) {
            assertNotNull("Exception must be thrown for empty consist", e.getMessage());
        }
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {

        String[] bogieIDs = {"BG101", "BG205"};

        try {
            TrainConsistManagementApp.searchWithValidation(bogieIDs, "BG101");
        } catch (IllegalStateException e) {
            fail("No exception expected when data exists: " + e.getMessage());
        }
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {

        String[] bogieIDs = {"BG101", "BG205", "BG309"};

        boolean result = TrainConsistManagementApp.searchWithValidation(bogieIDs, "BG205");

        assertTrue("BG205 must be found after validation passes", result);
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {

        String[] bogieIDs = {"BG101", "BG205", "BG309"};

        boolean result = TrainConsistManagementApp.searchWithValidation(bogieIDs, "BG999");

        assertFalse("BG999 must NOT be found after validation", result);
    }

    @Test
    public void testSearch_SingleElementValidCase() {

        String[] single = {"BG101"};

        boolean result = TrainConsistManagementApp.searchWithValidation(single, "BG101");

        assertTrue("Single element search must return true", result);
    }
}
