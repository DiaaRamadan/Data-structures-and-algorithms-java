package algorithms;

import java.util.Arrays;

public class QuickSelect {

    public static int[] findKthSmallest(int[] arr, int k) {
        findKthSmallest(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static int[] findKthLargest(int[] arr, int k) {
        findKthLargest(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private static void findKthSmallest(int[] arr, int start, int end, int k) {
        int pivot = Utils.partitionAsc(arr, start, end);

        if (pivot == k - 1)
            return;
        if (pivot < k - 1)
            findKthSmallest(arr, pivot + 1, end, k);
        else
            findKthSmallest(arr, start, pivot - 1, k);
    }

    private static void findKthLargest(int[] arr, int start, int end, int k) {
        int pivot = Utils.partitionADes(arr, start, end);

        if (pivot == k - 1)
            return;
        if (pivot < k - 1)
            findKthLargest(arr, pivot + 1, end, k);
        else
            findKthLargest(arr, start, pivot - 1, k);
    }

}
