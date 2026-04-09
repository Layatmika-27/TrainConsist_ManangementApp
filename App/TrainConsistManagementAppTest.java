import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Helper method: Linear Search
    private boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true; // early termination
            }
        }
        return false;
    }

    @Test
    void testSearch_BogieFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(bogies, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(linearSearch(bogies, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(bogies, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(bogies, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogies = {"BG101"};

        assertTrue(linearSearch(bogies, "BG101"));
    }
}