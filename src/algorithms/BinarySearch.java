package algorithms;

import java.util.List;

public class BinarySearch {

    private final List<Integer> numbers;

    public BinarySearch(List<Integer> numbers) {
        if (numbers.size() == 0) throw new IllegalArgumentException("List size is ZERO");
        this.numbers = numbers;
    }


    public Integer search(int number) {
        return search(0, numbers.size() - 1, number);
    }

    private Integer search(int start, int end, int number) {
        int mid = (start + end) / 2;
        int guess = numbers.get(mid);
        if (guess == number) return mid;
        if (start >= end) return null;
        if (guess < number) start = mid + 1;
        if (guess > number) end = mid - 1;
        return search(start, mid, number);
    }

}
