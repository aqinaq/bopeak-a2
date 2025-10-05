package cli;

import algorithms.MaxHeap;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {

        int[] inputSizes = {100, 1000, 10000, 100000};

        if (args.length > 0) {
            inputSizes = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                inputSizes[i] = Integer.parseInt(args[i]);
            }
        }

        System.out.println("Benchmarking MaxHeap...");
        System.out.println("InputSize,Time(ms),Comparisons,Swaps,ArrayAccesses");

        for (int n : inputSizes) {
            runBenchmark(n);
        }
    }
    private static void runBenchmark(int n) {
        MaxHeap heap = new MaxHeap(n);
        PerformanceTracker tracker = heap.getTracker();
        tracker.reset();

        Random random = new Random();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(n * 10);
        }

        long start = System.currentTimeMillis();

        for (int value : data) {
            heap.insert(value);
        }

        for (int i = 0; i < n; i++) {
            heap.extractMax();
        }

        long end = System.currentTimeMillis();
        long elapsed = end - start;
        tracker.setElapsedTime(elapsed); // сохраняем время в трекер

        System.out.println(n + "," + elapsed + "," +
                tracker.getComparisons() + "," +
                tracker.getSwaps() + "," +
                tracker.getArrayAccesses());

        tracker.exportToCSV("benchmark_" + n + ".csv");
    }
}
