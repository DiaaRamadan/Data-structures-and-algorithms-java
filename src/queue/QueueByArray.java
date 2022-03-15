package queue;

import java.util.Arrays;

public class QueueByArray {

    private int[] items;
    private int rear;
    private int count;
    private int front;

    public QueueByArray(int size) {
        this.items = new int[size];
    }

    public void enqueue(int item) {
        if (isFull()) throw new StackOverflowError();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException();
        int item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
