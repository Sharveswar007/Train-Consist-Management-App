import org.junit.Test;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private final String[] bogieIDs = {
        "BG101", "BG205", "BG309", "BG412", "BG550"
    };

    @Test
    public void testSearch_BogieFound() {

        boolean result = TrainConsistManagementApp.linearSearch(bogieIDs, "BG309");

        assertTrue("BG309 must be found in the list", result);
    }

    @Test
    public void testSearch_BogieNotFound() {

        boolean result = TrainConsistManagementApp.linearSearch(bogieIDs, "BG999");

        assertFalse("BG999 must NOT be found in the list", result);
    }

    @Test
    public void testSearch_FirstElementMatch() {

        boolean result = TrainConsistManagementApp.linearSearch(bogieIDs, "BG101");

        assertTrue("BG101 is first element and must be found", result);
    }

    @Test
    public void testSearch_LastElementMatch() {

        boolean result = TrainConsistManagementApp.linearSearch(bogieIDs, "BG550");

        assertTrue("BG550 is last element and must be found", result);
    }

    @Test
    public void testSearch_SingleElementArray() {

        String[] single = {"BG101"};

        boolean result = TrainConsistManagementApp.linearSearch(single, "BG101");

        assertTrue("Single element array match must return true", result);
    }
}
