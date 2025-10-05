package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long elapsedTime = 0;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        elapsedTime = 0;
    }

    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addArrayAccess(long count) { arrayAccesses += count; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    public void setElapsedTime(long millis) { elapsedTime = millis; }
    public long getElapsedTime() { return elapsedTime; }

    public void printMetrics() {
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Array Accesses: " + arrayAccesses);
        System.out.println("Elapsed Time(ms): " + elapsedTime);
    }

    public void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Comparisons,Swaps,ArrayAccesses,ElapsedTime(ms)\n");
            writer.write(comparisons + "," + swaps + "," + arrayAccesses + "," + elapsedTime + "\n");
            System.out.println("Metrics saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error: could not write CSV file");
        }
    }
}
