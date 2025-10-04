package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long arrayAccesses;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
    }

    public void addComparison() { comparisons++; }
    public void addSwap() { swaps++; }
    public void addArrayAccess(int count) { arrayAccesses += count; }

    // === Геттеры для BenchmarkRunner ===
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    public void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(comparisons + "," + swaps + "," + arrayAccesses + "\n");
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
