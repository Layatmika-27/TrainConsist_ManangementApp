import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Loop-based filtering
    private List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    private List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 50),
                new Bogie("B2", 70),
                new Bogie("B3", 80)
        );

        List<Bogie> result = filterUsingLoop(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 50),
                new Bogie("B2", 70),
                new Bogie("B3", 80)
        );

        List<Bogie> result = filterUsingStream(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("B1", 40),
                new Bogie("B2", 65),
                new Bogie("B3", 90)
        );

        List<Bogie> loopResult = filterUsingLoop(bogies);
        List<Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("B" + i, i));
        }

        long start = System.nanoTime();
        filterUsingStream(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("B" + i, i % 100));
        }

        List<Bogie> result = filterUsingStream(bogies);

        assertNotNull(result);
        assertTrue(result.size() > 0);
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }
}