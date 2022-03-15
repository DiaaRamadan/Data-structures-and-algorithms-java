package Heap;

public class Heap {

    private int[] nodes;
    private int size;

    public Heap(int size) {
        this.nodes = new int[size];
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();
        nodes[size++] = value;
        bubbleUp();

    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && nodes[index] > nodes[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    public int remove() {

        if (isEmpty()) throw new IllegalStateException();

        var root = nodes[0];
        nodes[0] = nodes[--size];

        bubbleDown();

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) :
                rightChildIndex(index);
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

        if (!hasRightChild(index))
            isValid &= nodes[index] >= rightChild(index);

        return isValid;
    }

    private void swap(int first, int second) {
        var node = nodes[first];
        nodes[first] = nodes[second];
        nodes[second] = node;
    }

    private boolean isFull() {
        return size == nodes.length;
    }

    private int leftChild(int index) {
        return nodes[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return nodes[rightChildIndex(index)];
    }

    private int rightChildIndex(int index) {
        return (getParent(index) * 2) + 2;
    }

    private int leftChildIndex(int index) {
        return (getParent(index) * 2) + 1;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }
}
