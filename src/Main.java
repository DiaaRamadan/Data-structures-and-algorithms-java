import Heap.HeapfiyArray;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 1, 2};
        HeapfiyArray.heapfiy(numbers);
        System.out.println(HeapfiyArray.getKthLargest(numbers, 1));
    }


}
