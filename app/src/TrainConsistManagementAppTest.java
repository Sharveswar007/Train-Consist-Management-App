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
    }
}
