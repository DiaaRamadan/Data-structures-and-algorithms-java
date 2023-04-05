package algorithms;

public class SortingAlgorithm {


    /**
     * Selection sort algorithm
     *
     * @param array Time complicity is O(n^2)
     *              Space complicity is O(1)
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallest = array[i];
            for (int j = i; j < array.length; j++) {
                int current = array[j];
                if (current < smallest) {
                    swap(i, j, array);
                    smallest = current;
                }
            }
        }
    }

    /**
     * Quick sort algorithm
     *
     * @param array Time complicity is O(n^2) in worst case,
     *              Time complicity is O(nlog(2)) in best case and
     *              Space complicity is O(1)
     */
    public static void quicksort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int b = low - 1;
        for (int i = low; i <= high; i++) {
            if (array[i] < pivot) {
                b++;
                swap(b, i, array);
            }
        }
        swap(b + 1, high, array);
        return b + 1;
    }

    private static void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }

    }

    private static void swap(int pos1, int pos2, int[] arr) {
        int value1 = arr[pos1];
        int value2 = arr[pos2];
        arr[pos1] = value2;
        arr[pos2] = value1;
    }


}
