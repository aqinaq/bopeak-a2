package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long timeMs = 0;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        timeMs = 0;
    }
    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addArrayAccess(long count) { arrayAccesses += count; }

    public void setTimeMs(long ms) { this.timeMs = ms; }
    public long getTimeMs() { return timeMs; }
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    public void printMetrics() {
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Array Accesses: " + arrayAccesses);
        System.out.println("Time (ms): " + timeMs);
    }

    public void exportToCSV(String filename, int inputSize) {
        FileWriter writer = null;

        try {
            writer = new FileWriter(filename);

            writer.write("InputSize,Time(ms),Comparisons,Swaps,ArrayAccesses\n");

            writer.write(inputSize + "," + timeMs + "," +
                    comparisons + "," + swaps + "," + arrayAccesses + "\n");
            System.out.println("metrics saved to " + filename);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: could not write CSV file");
        }
    }
}
