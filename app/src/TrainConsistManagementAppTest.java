import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> bogies;

    @Before
    public void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper",     72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair",    56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 18));
    }

    // ══════════════════════════════════════════
    // TEST 1
    // Total seat calculation must be correct
    // 72 + 56 + 18 = 146
    // ══════════════════════════════════════════
    @Test
    public void testReduce_TotalSeatCalculation() {

        int total = TrainConsistManagementApp.totalSeatingCapacity(bogies);

        assertEquals("Total seats must be 146",
                146, total);
    }

    // ══════════════════════════════════════════
    // TEST 2
    // All bogie capacities must be included
    // in the final aggregation
    // ══════════════════════════════════════════
    @Test
    public void testReduce_MultipleBogiesAggregation() {

        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("A", 50));
        list.add(new TrainConsistManagementApp.Bogie("B", 50));
        list.add(new TrainConsistManagementApp.Bogie("C", 50));

        int total = TrainConsistManagementApp.totalSeatingCapacity(list);

        assertEquals("Total must be 150 for three bogies of 50 each",
                150, total);
    }

    // ══════════════════════════════════════════
    // TEST 3
    // Single bogie total must equal
    // its own capacity
    // ══════════════════════════════════════════
    @Test
    public void testReduce_SingleBogieCapacity() {

        List<TrainConsistManagementApp.Bogie> single = new ArrayList<>();
        single.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        int total = TrainConsistManagementApp.totalSeatingCapacity(single);

        assertEquals("Single bogie total must equal its capacity",
                72, total);
    }

    // ══════════════════════════════════════════
    // TEST 4
    // Empty list must return 0
    // (identity value of reduce)
    // ══════════════════════════════════════════
    @Test
    public void testReduce_EmptyBogieList() {

        int total = TrainConsistManagementApp
                .totalSeatingCapacity(new ArrayList<>());

        assertEquals("Empty list must return total of 0",
                0, total);
    }

    // ══════════════════════════════════════════
    // TEST 5
    // map() must correctly extract capacity
    // values from Bogie objects
    // ══════════════════════════════════════════
    @Test
    public void testReduce_CorrectCapacityExtraction() {

        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.Bogie("X", 100));

        int total = TrainConsistManagementApp.totalSeatingCapacity(list);

        assertEquals("Capacity extracted must be 100",
                100, total);
    }

    // ══════════════════════════════════════════
    // TEST 6
    // All bogies must be included in total
    // Manual sum must match reduce result
    // ══════════════════════════════════════════
    @Test
    public void testReduce_AllBogiesIncluded() {

        int manualSum = 0;
        for (TrainConsistManagementApp.Bogie b : bogies) {
            manualSum += b.capacity;
        }

        int total = TrainConsistManagementApp.totalSeatingCapacity(bogies);

        assertEquals("Reduce result must match manual sum",
                manualSum, total);
    }

    // ══════════════════════════════════════════
    // TEST 7
    // Original list must remain unchanged
    // after reduce operation
    // ══════════════════════════════════════════
    @Test
    public void testReduce_OriginalListUnchanged() {

        int originalSize = bogies.size();

        TrainConsistManagementApp.totalSeatingCapacity(bogies);

        assertEquals("Original list must not be modified",
                originalSize, bogies.size());
    }
}