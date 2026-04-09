import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie class
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type) {
            this.type = type;
        }

        void assignCargo(String cargo) {
            try {
                if (type.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe assignment");
                }
                this.cargo = cargo;

            } catch (CargoSafetyException e) {
                // handled

            } finally {
                System.out.println("Assignment attempt completed");
            }
        }
    }

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // Should not crash
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");

        assertDoesNotThrow(() -> {
            b1.assignCargo("Petroleum"); // unsafe
            b2.assignCargo("Coal");      // safe
        });

        assertEquals("Coal", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        bogie.assignCargo("Petroleum");

        String consoleOutput = output.toString();

        assertTrue(consoleOutput.contains("Assignment attempt completed"));
    }
}