import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Helper method (same as UC20 logic)
    private boolean searchBogie(List<String> bogies, String key) {
        if (bogies.isEmpty()) {
            throw new IllegalStateException("Cannot perform search: No bogies available in the train.");
        }

        for (String id : bogies) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        List<String> bogies = new ArrayList<>();

        assertThrows(IllegalStateException.class, () -> {
            searchBogie(bogies, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        List<String> bogies = Arrays.asList("BG101", "BG205");

        assertDoesNotThrow(() -> {
            searchBogie(bogies, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        List<String> bogies = Arrays.asList("BG101", "BG205", "BG309");

        assertTrue(searchBogie(bogies, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        List<String> bogies = Arrays.asList("BG101", "BG205", "BG309");

        assertFalse(searchBogie(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        List<String> bogies = Collections.singletonList("BG101");

        assertTrue(searchBogie(bogies, "BG101"));
    }
}