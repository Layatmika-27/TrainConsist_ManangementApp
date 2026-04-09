import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Bogie collection (can be empty or populated)
        List<String> bogieIds = new ArrayList<>();

        // Uncomment below to test non-empty case
        // bogieIds.add("BG101");
        // bogieIds.add("BG205");

        String searchKey = "BG101";

        try {
            boolean result = searchBogie(bogieIds, searchKey);

            if (result) {
                System.out.println("Bogie ID " + searchKey + " found.");
            } else {
                System.out.println("Bogie ID " + searchKey + " not found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }

    // Search method with defensive programming
    public static boolean searchBogie(List<String> bogies, String key) {

        // Fail-fast check
        if (bogies.isEmpty()) {
            throw new IllegalStateException("Cannot perform search: No bogies available in the train.");
        }

        // Linear search
        for (String id : bogies) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }
}