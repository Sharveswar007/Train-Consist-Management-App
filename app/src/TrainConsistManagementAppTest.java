import org.junit.Test;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private final String[] bogieIDs = {
        "BG101", "BG205", "BG309", "BG412", "BG550"
    };

    @Test
    public void testBinarySearch_BogieFound() {

        boolean result = TrainConsistManagementApp.binarySearch(bogieIDs, "BG309");

        assertTrue("BG309 must be found using binary search", result);
    }

    @Test
    public void testBinarySearch_BogieNotFound() {

        boolean result = TrainConsistManagementApp.binarySearch(bogieIDs, "BG999");

        assertFalse("BG999 must NOT be found", result);
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {

        boolean result = TrainConsistManagementApp.binarySearch(bogieIDs, "BG101");

        assertTrue("BG101 first element must be found", result);
    }

    @Test
    public void testBinarySearch_LastElementMatch() {

        boolean result = TrainConsistManagementApp.binarySearch(bogieIDs, "BG550");

        assertTrue("BG550 last element must be found", result);
    }

    @Test
    public void testBinarySearch_SingleElementArray() {

        String[] single = {"BG101"};

        boolean result = TrainConsistManagementApp.binarySearch(single, "BG101");

        assertTrue("Single element match must return true", result);
    }

    @Test
    public void testBinarySearch_EmptyArray() {

        String[] empty = {};

        boolean result = TrainConsistManagementApp.binarySearch(empty, "BG101");

        assertFalse("Empty array must return false", result);
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {

        String[] unsorted = {
            "BG309", "BG101", "BG550", "BG205", "BG412"
        };

        boolean result = TrainConsistManagementApp.binarySearch(unsorted, "BG205");

        assertTrue("BG205 must be found even in unsorted input", result);
    }
}
