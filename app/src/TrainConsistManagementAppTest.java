import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> bogies;

    @Before
    public void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",     72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",    56));
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",     70));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 18));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",    60));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 20));
    }

    // ══════════════════════════════════════════
    // TEST 1
    // Bogies must be grouped correctly by type
    // ══════════════════════════════════════════
    @Test
    public void testGrouping_BogiesGroupedByType() {

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        // Sleeper key must exist
        assertTrue("Sleeper group must exist",
                grouped.containsKey("Sleeper"));
    }

    // ══════════════════════════════════════════
    // TEST 2
    // Multiple bogies of same type must be
    // placed in the same group
    // ══════════════════════════════════════════
    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        // Two Sleeper bogies must be in same group
        assertEquals("Sleeper group must contain 2 bogies",
                2, grouped.get("Sleeper").size());
    }

    // ══════════════════════════════════════════
    // TEST 3
    // Bogies of different types must be in
    // separate groups
    // ══════════════════════════════════════════
    @Test
    public void testGrouping_DifferentBogieTypes() {

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue("Sleeper group must exist",
                grouped.containsKey("Sleeper"));
        assertTrue("AC Chair group must exist",
                grouped.containsKey("AC Chair"));
        assertTrue("First Class group must exist",
                grouped.containsKey("First Class"));
    }

    // ══════════════════════════════════════════
    // TEST 4
    // Grouping an empty list must return
    // an empty map without errors
    // ══════════════════════════════════════════
    @Test
    public void testGrouping_EmptyBogieList() {

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(new ArrayList<>());

        assertTrue("Empty list must return empty map",
                grouped.isEmpty());
    }

    // ══════════════════════════════════════════
    // TEST 5
    // When only one bogie type exists,
    // map must contain only one key
    // ══════════════════════════════════════════
    @Test
    public void testGrouping_SingleBogieCategory() {

        List<TrainConsistManagementApp.Bogie> single = new ArrayList<>();
        single.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        single.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(single);

        assertEquals("Map must have only one key",
                1, grouped.size());
    }

    // ══════════════════════════════════════════
    // TEST 6
    // Map must contain all expected bogie
    // type keys
    // ══════════════════════════════════════════
    @Test
    public void testGrouping_MapContainsCorrectKeys() {

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue("Map must contain all 3 bogie types",
                grouped.keySet().containsAll(
                        Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    // ══════════════════════════════════════════
    // TEST 7
    // Group size must match expected count
    // ══════════════════════════════════════════
    @Test
    public void testGrouping_GroupSizeValidation() {

        Map<String, List<TrainConsistManagementApp.Bogie>> grouped =
                TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals("AC Chair group must contain 2 bogies",
                2, grouped.get("AC Chair").size());

        assertEquals("First Class group must contain 2 bogies",
                2, grouped.get("First Class").size());
    }

    // ══════════════════════════════════════════
    // TEST 8
    // Original list must remain unchanged
    // after grouping operation
    // ══════════════════════════════════════════
    @Test
    public void testGrouping_OriginalListUnchanged() {

        int originalSize = bogies.size();

        TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals("Original list must not be modified",
                originalSize, bogies.size());
    }
}