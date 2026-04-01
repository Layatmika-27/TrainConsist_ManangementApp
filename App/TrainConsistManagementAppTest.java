import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Regex patterns
    private static final String TRAIN_REGEX = "TRN-\\d{4}";
    private static final String CARGO_REGEX = "PET-[A-Z]{2}";

    // Helper validation methods
    private boolean isValidTrainId(String trainId) {
        return Pattern.matches(TRAIN_REGEX, trainId);
    }

    private boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches(CARGO_REGEX, cargoCode);
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainId("TRAIN12"));
        assertFalse(isValidTrainId("TRN12A"));
        assertFalse(isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET-ab"));   // lowercase
        assertFalse(isValidCargoCode("PET123"));   // missing dash
        assertFalse(isValidCargoCode("AB-PET"));   // wrong order
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainId("TRN-123"));    // less digits
        assertFalse(isValidTrainId("TRN-12345"));  // more digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("PET-Ab"));
        assertFalse(isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainId(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainId("TRN-1234X")); // extra character
        assertFalse(isValidCargoCode("XPET-AB")); // prefix extra
    }
}