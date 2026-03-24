import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Initialize passenger bogies list
        List<String> passengerBogies = new ArrayList<>();

        // Adding bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("Current bogies: " + passengerBogies);

        // Remove a bogie
        passengerBogies.remove("AC Chair");

        // Display after removal
        System.out.println("Bogies after removal: " + passengerBogies);

        // Check existence
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("Sleeper exists? " + exists);

        // Final state
        System.out.println("Final bogie list: " + passengerBogies);
    }
}