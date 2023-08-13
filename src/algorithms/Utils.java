package algorithms;

public class Utils {
    static int partitionAsc(int[] arr, int start, int end) {
        int pivot = arr[end];
        int boundary = start - 1;

        while (start <= end) {
            if (arr[start] <= pivot)
                swap(start, ++boundary, arr);
            start++;
        }

        return boundary;

    }

    static int partitionADes(int[] arr, int start, int end) {
        int pivot = arr[end];
        int boundary = start - 1;

        while (start <= end) {
            if (arr[start] >= pivot)
                swap(++boundary, start, arr);
            start++;
        }
        return boundary;
    }

    static void swap(int pos1, int pos2, int[] arr) {
        int value1 = arr[pos1];
        int value2 = arr[pos2];
        arr[pos1] = value2;
        arr[pos2] = value1;
    }
}
