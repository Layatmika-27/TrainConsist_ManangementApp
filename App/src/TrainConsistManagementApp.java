import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Array of bogie type names
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "Cargo", "General"};

        // Sort using built-in method
        Arrays.sort(bogieTypes);

        // Display sorted result
        System.out.println("Sorted Bogie Types:");
        System.out.println(Arrays.toString(bogieTypes));

        // Program continues
        System.out.println("Sorting complete.");
    }
}