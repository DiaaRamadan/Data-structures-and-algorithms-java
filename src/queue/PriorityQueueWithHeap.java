package queue;

import Heap.Heap;

public class PriorityQueueWithHeap {

    private final Heap heap = new Heap(100);

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
