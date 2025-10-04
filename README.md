Max-Heap implementation - Assignment 2
Bakytkeldy Akbope Se-2426
# Assignment 2 – MaxHeap Implementation (Pair 4: Student B)

## Overview
My task was to implement **Max-Heap** with operations:
- insert
- increaseKey
- extractMax

the project contains:
- Performance tracking (comparisons, swaps, array accesses)
- Benchmark runner with configurable input sizes
- Unit tests with edge cases

---


## 🚀 How to Run

### 1. Compile the project
```bash
mvn clean compile
```
benchmark_100.csv : Comparisons, Swaps, Array accesses
711,542,1384
benchmark_1000.csv : Comparisons, Swaps, Array accesses
11950,8559,20118
benchmark_10000.csv : Comparisons, Swaps, Array accesses
169664,119392,268784
##  Benchmark Analysis

The benchmark results for the MaxHeap implementation confirm the expected asymptotic behavior.

Insert and extractMax operations scale in O(log n) time.

When running benchmarks with input sizes up to n = 100000, the measured execution times and operation counts (comparisons, swaps, array accesses) grow approximately proportional to n log n.

For n = 1000, the runtime was only a few milliseconds, but the number of comparisons (~12,000) and swaps (~8,600) already illustrates the logarithmic growth pattern.

Larger input sizes show that although constant factors affect practical runtime, the overall growth trend matches the theoretical analysis.

Conclusion:
The empirical measurements validate the theoretical complexity of the MaxHeap. As input size increases, performance scales consistently with the Θ(n log n) complexity class. Minor variations are explained by JVM overhead, memory allocations, and system scheduling.

##  Complexity Analysis (Theoretical)

- **Insert(x):** O(log n), since the new key may need to bubble up the heap.
- **IncreaseKey(i, key):** O(log n), as the updated key may percolate upward.
- **ExtractMax():** O(log n), since heapify-down is required after removing the max element.
- **BuildHeap():** O(n), when constructing the heap from an array.

**Space Complexity:** O(n) for storing heap elements in an array.  
Auxiliary space is O(1) (in-place operations).

## Testing

The project includes:
- **Unit Tests** with JUnit for:
    - empty heap
    - single element
    - duplicate elements
    - increasing sequence
    - random large inputs
- Cross-validation with Java's built-in `PriorityQueue` for correctness.
##  Results Summary

| Input Size | Comparisons | Swaps  | Array Accesses |
|------------|-------------|--------|----------------|
| 100        | 711         | 542    | 1384           |
| 1000       | 11,950      | 8,559  | 20,118         |
| 10000      | 169,664     | 119,392| 268,784        |
