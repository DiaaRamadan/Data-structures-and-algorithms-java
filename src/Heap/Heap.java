package Heap;

public class Heap {

    private int[] nodes;
    private int size;

    public Heap(int size) {
        nodes = new int[size];
    }

    public void insert(int node) {
        if (isFull())
            throw new IllegalStateException();
        nodes[size++] = node;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        var root = nodes[0];
        nodes[0] = nodes[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            var largeChildIndex = largerChildIndex(index);
            swap(index, largeChildIndex);
            index = largeChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {

        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index))
                ? leftChildIndex(index)
                : rightChildIndex(index);
    }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException();
        return nodes[0];
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = nodes[index] >= leftChild(index);
        if (hasRightChild(index))
            isValid &= nodes[index] >= rightChild(index);

        return isValid;
    }

    private int leftChild(int index) {
        return nodes[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return nodes[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && nodes[index] > nodes[parent(index)]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    private void swap(int first, int second) {
        int node = nodes[first];
        nodes[first] = nodes[second];
        nodes[second] = node;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private boolean isFull() {
        return size == nodes.length;
    }

}