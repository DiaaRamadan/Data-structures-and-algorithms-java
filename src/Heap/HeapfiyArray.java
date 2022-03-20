package Heap;

public class HeapfiyArray {

    public static void heapfiy(int[] numbers) {
        var lastParent = (numbers.length / 2 - 1);
        for (int i = lastParent; i > 0; i--)
            heapfiy(numbers, i);
    }

    private static void heapfiy(int[] numbers, int index) {

        var largeIndex = index;
        var leftChildIndex = (index * 2) + 1;
        if (leftChildIndex < numbers.length && numbers[leftChildIndex] > numbers[largeIndex])
            largeIndex = leftChildIndex;

        var rightChildIndex = (index * 2) + 2;
        if (rightChildIndex < numbers.length && numbers[rightChildIndex] > numbers[largeIndex])
            largeIndex = rightChildIndex;

        if (index == largeIndex) return;
        swap(index, largeIndex, numbers);
        heapfiy(numbers, largeIndex);
    }

    public static int getKthLargest(int[] numbers, int k) {

        if (k < 1 || k > numbers.length)
            throw new IllegalStateException();

        Heap heap = new Heap(numbers.length);
        for (var number : numbers)
            heap.insert(number);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }

    private static void swap(int first, int second, int[] array) {
        int item = array[first];
        array[first] = array[second];
        array[second] = item;
    }
}
