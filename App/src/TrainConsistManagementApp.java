public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Array of passenger bogie capacities
        int[] capacities = {72, 24, 78, 50, 60};

        // Bubble Sort implementation
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {
            // Each pass
            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Display sorted capacities
        System.out.println("Sorted Bogie Capacities:");
        for (int capacity : capacities) {
            System.out.print(capacity + " ");
        }

        // Program continues
        System.out.println("\nSorting complete.");
    }
}