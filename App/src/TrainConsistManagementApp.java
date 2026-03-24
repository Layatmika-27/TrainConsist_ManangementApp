import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Initialize HashSet for unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Adding bogie IDs
        bogieIds.add("B101");
        bogieIds.add("B102");
        bogieIds.add("B103");

        // Attempt to add duplicate IDs
        bogieIds.add("B102");
        bogieIds.add("B101");

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs: " + bogieIds);
    }
}