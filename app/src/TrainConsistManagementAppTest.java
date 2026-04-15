import org.junit.Test;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    @Test
    public void testSort_BasicAlphabeticalSorting() {

        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};

        String[] result = TrainConsistManagementApp.sortBogieNames(input);

        assertArrayEquals("Names must be sorted alphabetically", expected, result);
    }

    @Test
    public void testSort_UnsortedInput() {

        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};

        String[] result = TrainConsistManagementApp.sortBogieNames(input);

        assertArrayEquals("Unsorted input must become alphabetically ordered", expected, result);
    }

    @Test
    public void testSort_AlreadySortedArray() {

        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};

        String[] result = TrainConsistManagementApp.sortBogieNames(input);

        assertArrayEquals("Already sorted array must remain unchanged", expected, result);
    }

    @Test
    public void testSort_DuplicateBogieNames() {

        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};

        String[] result = TrainConsistManagementApp.sortBogieNames(input);

        assertArrayEquals("Duplicate names must be retained and sorted", expected, result);
    }

    @Test
    public void testSort_SingleElementArray() {

        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        String[] result = TrainConsistManagementApp.sortBogieNames(input);

        assertArrayEquals("Single element array must remain unchanged", expected, result);
    // ══════════════════════════════════════════
    // TEST 1
    // Basic unsorted array must be sorted
    // correctly in ascending order
    // ══════════════════════════════════════════
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
