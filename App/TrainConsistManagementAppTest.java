import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Reusing Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Helper method for filtering
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 78),
                new Bogie("First Class", 24)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 78)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("AC Chair", result.get(0).name);
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 24),
                new Bogie("Second Sitting", 50)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 78),
                new Bogie("Luxury", 100)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 24),
                new Bogie("General", 50)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 78)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertEquals(bogies.size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));

        int originalSize = bogies.size();

        List<Bogie> result = filterBogies(bogies, 70);

        // Original list should remain unchanged
        assertEquals(originalSize, bogies.size());
        assertEquals(2, bogies.size());
    }
}