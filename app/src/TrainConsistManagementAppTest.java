import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrainConsistManagementAppTest {

    // ══════════════════════════════════════════
    // TEST 1
    // All valid bogies must return true
    // ══════════════════════════════════════════
    @Test
    public void testSafety_AllBogiesValid() {

        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.GoodsBogie(
                "Cylindrical", "Petroleum"));
        list.add(new TrainConsistManagementApp.GoodsBogie(
                "Rectangular", "Coal"));

        assertTrue("All valid bogies must return true",
                TrainConsistManagementApp.isSafetyCompliant(list));
    }

    // ══════════════════════════════════════════
    // TEST 2
    // Cylindrical bogie with Coal must fail
    // ══════════════════════════════════════════
    @Test
    public void testSafety_CylindricalWithInvalidCargo() {

        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.GoodsBogie(
                "Cylindrical", "Coal"));

        assertFalse("Cylindrical with Coal must return false",
                TrainConsistManagementApp.isSafetyCompliant(list));
    }

    // ══════════════════════════════════════════
    // TEST 3
    // Non-cylindrical bogies must allow
    // any cargo type
    // ══════════════════════════════════════════
    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {

        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.GoodsBogie(
                "Rectangular", "Coal"));
        list.add(new TrainConsistManagementApp.GoodsBogie(
                "Rectangular", "Grain"));

        assertTrue("Non-cylindrical bogies must allow any cargo",
                TrainConsistManagementApp.isSafetyCompliant(list));
    }

    // ══════════════════════════════════════════
    // TEST 4
    // Even one violation must make the
    // entire train unsafe
    // ══════════════════════════════════════════
    @Test
    public void testSafety_MixedBogiesWithViolation() {

        List<TrainConsistManagementApp.GoodsBogie> list = new ArrayList<>();
        list.add(new TrainConsistManagementApp.GoodsBogie(
                "Cylindrical", "Petroleum"));
        list.add(new TrainConsistManagementApp.GoodsBogie(
                "Cylindrical", "Coal"));      // violation

        assertFalse("One violation must make entire train unsafe",
                TrainConsistManagementApp.isSafetyCompliant(list));
    }

    // ══════════════════════════════════════════
    // TEST 5
    // Empty bogie list must return true
    // (no violations possible)
    // ══════════════════════════════════════════
    @Test
    public void testSafety_EmptyBogieList() {

        assertTrue("Empty list must return true",
                TrainConsistManagementApp.isSafetyCompliant(new ArrayList<>()));
    }
}