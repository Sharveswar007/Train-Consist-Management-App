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
        bogies.add(new TrainConsistManagementApp.Bogie("Executive",   80));
        bogies.add(new TrainConsistManagementApp.Bogie("Economy",     48));
    }

    // ══════════════════════════════════════════
    // TEST 1
    // Loop filtering must exclude bogies
    // with capacity <= threshold
    // ══════════════════════════════════════════
    @Test
    public void testLoopFilteringLogic() {

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterByLoop(bogies, 60);

        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.name + " must have capacity > 60",
                    b.capacity > 60);
        }
    }

    // ══════════════════════════════════════════
    // TEST 2
    // Stream filtering must exclude bogies
    // with capacity <= threshold
    // ══════════════════════════════════════════
    @Test
    public void testStreamFilteringLogic() {

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterByStream(bogies, 60);

        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.name + " must have capacity > 60",
                    b.capacity > 60);
        }
    }

    // ══════════════════════════════════════════
    // TEST 3
    // Both methods must produce same results
    // ══════════════════════════════════════════
    @Test
    public void testLoopAndStreamResultsMatch() {

        List<TrainConsistManagementApp.Bogie> loopResult =
                TrainConsistManagementApp.filterByLoop(bogies, 60);
        List<TrainConsistManagementApp.Bogie> streamResult =
                TrainConsistManagementApp.filterByStream(bogies, 60);

        assertEquals("Loop and stream results must match",
                loopResult.size(), streamResult.size());
    }

    // ══════════════════════════════════════════
    // TEST 4
    // Execution time must be greater than 0
    // ══════════════════════════════════════════
    @Test
    public void testExecutionTimeMeasurement() {

        long start   = System.nanoTime();
        TrainConsistManagementApp.filterByLoop(bogies, 60);
        long elapsed = System.nanoTime() - start;

        assertTrue("Elapsed time must be greater than 0",
                elapsed > 0);
    }

    // ══════════════════════════════════════════
    // TEST 5
    // Large dataset must be processed correctly
    // ══════════════════════════════════════════
    @Test
    public void testLargeDatasetProcessing() {

        List<TrainConsistManagementApp.Bogie> large = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            large.add(new TrainConsistManagementApp.Bogie(
                    "Bogie-" + i, 30 + (i % 80)));
        }

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterByStream(large, 60);

        assertFalse("Large dataset result must not be empty",
                result.isEmpty());
    }
}