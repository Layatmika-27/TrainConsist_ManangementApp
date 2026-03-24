import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Initialize LinkedList for train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add initial bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // Insert Pantry Car at position 2 (index 1)
        trainConsist.add(1, "Pantry Car");

        // Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // Display final ordered train consist
        System.out.println("Final Train Consist: " + trainConsist);
    }
}