package metrics;

import java.io.FileWriter;
import java.io.IOException;
public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
    }
    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addArrayAccess(long count) { arrayAccesses += count; }

    public void printMetrics() {
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Array Accesses: " + arrayAccesses);
    }
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    public void exportToCSV(String filename) {
        FileWriter writer = null;

        try {
            writer = new FileWriter(filename);

            writer.write("Comparisons, Swaps, Array accesses\n");

            writer.write(comparisons +"," + swaps + ","+ arrayAccesses + "\n");
            System.out.println("metrics saved to " + filename);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: could not write CSV file");
        }
    }
}
