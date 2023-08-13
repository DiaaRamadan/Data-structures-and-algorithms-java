package algorithms;

public class SelectionSort {

    /**
     * Selection sort algorithm
     *
     * @param array Time complicity is O(n^2)
     *              Space complicity is O(1)
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallest = array[i];
            for (int j = i; j < array.length; j++) {
                int current = array[j];
                if (current < smallest) {
                    Utils.swap(i, j, array);
                    smallest = current;
                }
            }
        }
    }
}
