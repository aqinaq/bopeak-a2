package algorithms;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {

    @Test
    public void testEmptyHeapExtract() {
        MaxHeap heap = new MaxHeap(10);
        assertEquals(Integer.MIN_VALUE, heap.extractMax(), "Extracting from empty heap should return MIN_VALUE");
    }
    @Test
    public void testSingleElement() {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(5);
        assertEquals(5, heap.extractMax(), "Heap with single element should return that element");
        assertEquals(Integer.MIN_VALUE, heap.extractMax(), "Now heap is empty, should return MIN_VALUE");
    }
    @Test
    public void testDuplicates() {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(5);
        heap.insert(5);
        heap.insert(5);
        assertEquals(5, heap.extractMax());
        assertEquals(5, heap.extractMax());
        assertEquals(5, heap.extractMax());
    }
    @Test
    public void testSortedInput() {
        MaxHeap heap = new MaxHeap(10);
        for (int i = 1; i <= 5; i++) heap.insert(i);
        for (int i = 5; i >= 1; i--) {
            assertEquals(i, heap.extractMax());
        }
    }
    @Test
    public void testReverseSortedInput() {
        MaxHeap heap = new MaxHeap(10);
        for (int i = 5; i >= 1; i--) heap.insert(i);
        for (int i = 5; i >= 1; i--) {
            assertEquals(i, heap.extractMax());
        }
    }
    @Test
    public void testIncreaseKey() {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.increaseKey(0, 5); // increase first element
        assertEquals(5, heap.extractMax());
    }
    @Test
    public void propertyBasedRandomTest() {
        int n = 100;
        MaxHeap heap = new MaxHeap(n);
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int val = rand.nextInt(1000);
            heap.insert(val);
            arr[i] = val;
        }
        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i--) {
            assertEquals(arr[i], heap.extractMax());
        }
    }
    @Test
    public void crossValidationWithPriorityQueue() {
        MaxHeap heap = new MaxHeap(10);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] data = {3, 1, 4, 1, 5, 9, 2};
        for (int x : data) {
            heap.insert(x);
            pq.add(x);
        }
        while (!pq.isEmpty()) {
            assertEquals(pq.poll(), heap.extractMax());
        }
    }
}

