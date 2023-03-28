package algorithms;

import java.util.List;

public class BinarySearch {

    private List<Integer> items;

    public BinarySearch(List<Integer> items) {
        if (items.size() == 0) throw new IllegalArgumentException("List size is ZERO");
        this.items = items;
    }


    public Integer recursiveSearch(int number) {
        return search(0, items.size() - 1, number);
    }

    public Integer iterativeSearch(int number) {
        int start = 0;
        int end = items.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int guess = items.get(mid);
            if (number == guess) return mid;
            else if (number < guess) end = mid - 1;
            else start = mid + 1;
        }
        return null;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    private Integer search(int start, int end, int number) {
        int mid = (start + end) / 2;
        int guess = items.get(mid);
        if (guess == number) return mid;
        if (start >= end) return null;
        if (guess < number) start = mid + 1;
        if (guess > number) end = mid - 1;
        return search(start, mid, number);
    }

}
