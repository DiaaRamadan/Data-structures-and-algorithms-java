import HashTable.HashTable;
import algorithms.BinarySearch;
import algorithms.SortingAlgorithm;
import com.arrays.Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var arr = new int[]{4, 8, 7, 2, 0, 4, 5};

        SortingAlgorithm.quicksort(arr);

        System.out.println(Arrays.toString(arr));

    }


}
