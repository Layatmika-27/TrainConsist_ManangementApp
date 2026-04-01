import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        // Category logic (for grouping)
        String getCategory() {
            if (capacity >= 70) return "High Capacity";
            else if (capacity >= 40) return "Medium Capacity";
            else return "Low Capacity";
        }

        @Override
        public String toString() {
            return name + " (" + capacity + ")";
        }
    }

    public static void main(String[] args) {

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Second Sitting", 50));

        // Grouping using Stream API
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.getCategory()));

        // Display grouped result
        System.out.println("Grouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Program continues
        System.out.println("Grouping complete.");
    }
}