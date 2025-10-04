package algorithms;

import metrics.PerformanceTracker;
public class MaxHeap {
    private int[] heap;
    private int size;
    private PerformanceTracker tracker;
    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
        tracker = new PerformanceTracker();
    }
    public int getSize() {
        return size;
    }
    public void insert(int key) {
        if (size == heap.length) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = key;
        tracker.addArrayAccess(1);
        int current = size;
        size++;

        while (current > 0 && heap[current] > heap[parent(current)]) {
            tracker.addComparison();
            swap(current, parent(current));
            tracker.addSwap();
            tracker.addArrayAccess(2);
            current = parent(current);
        }
    }
    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }
        if (newValue < heap[index]) {
            System.out.println("New value is smaller than current key!");
            return;
        }
        heap[index] = newValue;
        tracker.addArrayAccess(1);

        while (index > 0 && heap[index] > heap[parent(index)]) {
            tracker.addComparison();
            swap(index, parent(index));
            tracker.addSwap();
            tracker.addArrayAccess(2);
            index = parent(index);
        }
    }
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return Integer.MIN_VALUE;
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        tracker.addArrayAccess(2);

        heapify(0);
        return max;
    }
    private void heapify(int index) {
        int left = left(index);
        int right = right(index);
        int largest = index;

        if (left < size && heap[left] > heap[largest]) {
            tracker.addComparison();
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            tracker.addComparison();
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            tracker.addSwap();
            tracker.addArrayAccess(2);
            heapify(largest);
        }
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public void buildHeap(int[] arr) {
        if (arr.length > heap.length) {
            System.out.println("Array too big for heap capacity!");
            return;
        }
        size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            heap[i] = arr[i];
            tracker.addArrayAccess(1);
        }
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }
    private void heapifyDown(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);

        if (left < size && heap[left] > heap[largest]) {
            tracker.addComparison();
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            tracker.addComparison();
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            tracker.addSwap();
            tracker.addArrayAccess(2);
            heapifyDown(largest);
        }
    }
    public PerformanceTracker getTracker() {
        return tracker;
    }
}
