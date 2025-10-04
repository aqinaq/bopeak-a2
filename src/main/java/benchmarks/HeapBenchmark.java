package benchmarks;

import algorithms.MaxHeap;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.Random;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class HeapBenchmark {

    private MaxHeap heap;
    private int[] data;
    private Random random = new Random();

    @Param({"1000", "10000", "100000"})
    private int n;

    @Setup(Level.Iteration)
    public void setup() {
        heap = new MaxHeap(n);
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt();
            heap.insert(data[i]);
        }
    }

    @Benchmark
    public void benchmarkInsert() {
        heap.insert(random.nextInt());
    }

    @Benchmark
    public void benchmarkExtractMax() {
        heap.extractMax();
    }

    @Benchmark
    public void benchmarkIncreaseKey() {
        int index = random.nextInt(n);
        heap.increaseKey(index, random.nextInt());
    }
}
