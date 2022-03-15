package com.arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        // if array is full, resize it
        if (items.length == count) {
            int[] newArray = new int[count * 2];
            // copy all existing items
            for (int i = 0; i < count; i++) {
                newArray[i] = items[i];
            }
            // set items to new Array
            items = newArray;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {

        if (index < 0 || count <= index)
            throw new IllegalArgumentException();

        // shift all items
        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public int max() {
        int max = items[0];
        for (int i = 1; i < count - 1; i++) {
            if (max >= items[i])
                continue;
            max = items[i];
        }
        return max;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);

    }
}
