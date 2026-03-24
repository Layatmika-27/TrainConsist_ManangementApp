import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainConsistManagementApp {

    // Bogie class (custom object)
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    public static void main(String[] args) {

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogie objects
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));
        bogies.add(new Bogie("First Class", 24));

        // Sort bogies by capacity using Comparator (lambda)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // Display sorted bogies
        System.out.println("Bogies sorted by capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Program continues
        System.out.println("Sorting complete.");
    }
}