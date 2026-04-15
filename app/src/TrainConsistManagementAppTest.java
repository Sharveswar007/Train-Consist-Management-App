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
    public void testSort_BasicSorting() {

        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        int[] result = TrainConsistManagementApp.bubbleSort(input);

        assertArrayEquals("Array must be sorted in ascending order",
                expected, result);
    }

    // ══════════════════════════════════════════
    // TEST 2
    // Already sorted array must remain
    // unchanged after sorting
    // ══════════════════════════════════════════
    @Test
    public void testSort_AlreadySortedArray() {

        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        int[] result = TrainConsistManagementApp.bubbleSort(input);

        assertArrayEquals("Already sorted array must remain unchanged",
                expected, result);
    }

    // ══════════════════════════════════════════
    // TEST 3
    // Duplicate values must be handled
    // correctly and sorted properly
    // ══════════════════════════════════════════
    @Test
    public void testSort_DuplicateValues() {

        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        int[] result = TrainConsistManagementApp.bubbleSort(input);

        assertArrayEquals("Duplicate values must be handled correctly",
                expected, result);
    }

    // ══════════════════════════════════════════
    // TEST 4
    // Single element array must remain
    // unchanged after sorting
    // ══════════════════════════════════════════
    @Test
    public void testSort_SingleElementArray() {

        int[] input = {50};
        int[] expected = {50};

        int[] result = TrainConsistManagementApp.bubbleSort(input);

        assertArrayEquals("Single element array must remain unchanged",
                expected, result);
    }

    // ══════════════════════════════════════════
    // TEST 5
    // All equal values must remain unchanged
    // after sorting
    // ══════════════════════════════════════════
    @Test
    public void testSort_AllEqualValues() {

        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};

        int[] result = TrainConsistManagementApp.bubbleSort(input);

        assertArrayEquals("All equal values must remain unchanged",
                expected, result);
    }
}
