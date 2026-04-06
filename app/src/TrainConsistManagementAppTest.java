import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class TrainConsistManagementAppTest {

    // ─────────────────────────────────────────
    // Shared bogie list reset before each test
    // ─────────────────────────────────────────
    private List<TrainConsistManagementApp.Bogie> bogies;

    @Before
    public void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",     72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",    56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 18));
        bogies.add(new TrainConsistManagementApp.Bogie("Executive",   80));
        bogies.add(new TrainConsistManagementApp.Bogie("Economy",     48));
    }

    // ══════════════════════════════════════════
    // TEST 1
    // Bogies with capacity GREATER THAN threshold
    // must appear in the filtered result
    // ══════════════════════════════════════════
    @Test
    public void testFilter_CapacityGreaterThanThreshold() {

        // Given threshold = 70
        // Sleeper(72) and Executive(80) qualify → 2 bogies
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(bogies, 70);

        // Expected: 2 bogies returned
        assertEquals(2, result.size());

        // All returned bogies must have capacity > 70
        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.name + " should have capacity > 70",
                    b.capacity > 70);
        }
    }

    // ══════════════════════════════════════════
    // TEST 2
    // Bogies with capacity EQUAL TO threshold
    // must NOT be included (filter is strictly >)
    // ══════════════════════════════════════════
    @Test
    public void testFilter_CapacityEqualToThreshold_NotIncluded() {

        // Threshold = 72, Sleeper has exactly 72
        // Sleeper must NOT appear since 72 is NOT > 72
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(bogies, 72);

        boolean sleeperFound = false;
        for (TrainConsistManagementApp.Bogie b : result) {
            if (b.name.equals("Sleeper")) {
                sleeperFound = true;
                break;
            }
        }

        assertFalse("Sleeper with capacity 72 should NOT appear " +
                "when threshold is 72", sleeperFound);
    }

    // ══════════════════════════════════════════
    // TEST 3
    // Bogies with capacity LESS THAN threshold
    // must be excluded from the result
    // ══════════════════════════════════════════
    @Test
    public void testFilter_CapacityLessThanThreshold_Excluded() {

        // Threshold = 70
        // AC Chair(56), First Class(18), Economy(48) must be excluded
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(bogies, 70);

        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.name + " has capacity <= 70 and should be excluded",
                    b.capacity > 70);
        }
    }

    // ══════════════════════════════════════════
    // TEST 4
    // When MULTIPLE bogies match the condition,
    // ALL of them must appear in the result
    // ══════════════════════════════════════════
    @Test
    public void testFilter_MultipleBogiesMatching() {

        // Threshold = 50
        // Sleeper(72), AC Chair(56), Executive(80) → 3 bogies qualify
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(bogies, 50);

        assertEquals("Three bogies should match capacity > 50",
                3, result.size());
    }

    // ══════════════════════════════════════════
    // TEST 5
    // When NO bogies match the condition,
    // result must be an EMPTY list
    // ══════════════════════════════════════════
    @Test
    public void testFilter_NoBogiesMatching() {

        // Threshold = 100 → no bogie has capacity > 100
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(bogies, 100);

        assertTrue("Result should be empty when no bogie exceeds 100",
                result.isEmpty());
    }

    // ══════════════════════════════════════════
    // TEST 6
    // When ALL bogies match the condition,
    // entire list must be returned
    // ══════════════════════════════════════════
    @Test
    public void testFilter_AllBogiesMatching() {

        // Threshold = 10 → all bogies have capacity > 10
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(bogies, 10);

        assertEquals("All bogies should match when threshold is very low",
                bogies.size(), result.size());
    }

    // ══════════════════════════════════════════
    // TEST 7
    // Filtering an EMPTY list must return
    // an empty result without any errors
    // ══════════════════════════════════════════
    @Test
    public void testFilter_EmptyBogieList() {

        List<TrainConsistManagementApp.Bogie> emptyList = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(emptyList, 60);

        assertTrue("Filtering an empty list must return an empty result",
                result.isEmpty());
    }

    // ══════════════════════════════════════════
    // TEST 8
    // The ORIGINAL list must remain UNCHANGED
    // after the stream filtering operation
    // ══════════════════════════════════════════
    @Test
    public void testFilter_OriginalListUnchanged() {

        // Record original size before filtering
        int originalSize = bogies.size();

        // Perform filtering
        TrainConsistManagementApp.filterBogiesByCapacity(bogies, 60);

        // Original list must still have the same size
        assertEquals("Original bogie list must not be modified after filtering",
                originalSize, bogies.size());
    }
}