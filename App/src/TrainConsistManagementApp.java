import java.util.ArrayList;
import java.util.List;
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
    }

    public static void main(String[] args) {

        // Create collection of bogies
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            bogies.add(new Bogie("Bogie" + i, i % 100));
        }

        // -------- Loop-based filtering --------
        long startLoop = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 50) {
                loopFiltered.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // -------- Stream-based filtering --------
        long startStream = System.nanoTime();

        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Display execution times
        System.out.println("Loop Filtering Time (ns): " + loopTime);
        System.out.println("Stream Filtering Time (ns): " + streamTime);

        // Program continues
        System.out.println("Performance comparison complete.");
    }
}