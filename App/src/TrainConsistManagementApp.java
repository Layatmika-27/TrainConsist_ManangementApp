public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Array of bogie IDs (unsorted)
        String[] bogieIds = {"B101", "B205", "B150", "B310", "B220"};

        // Search key
        String searchKey = "B150";

        boolean found = false;

        // Linear Search
        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                found = true;
                break; // early termination
            }
        }

        // Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }

        // Program continues
        System.out.println("Search complete.");
    }
}