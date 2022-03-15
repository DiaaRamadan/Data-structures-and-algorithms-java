package queue;

import java.util.EmptyStackException;
import java.util.Stack;

class QueueByStack {

    private int size = 0;
    private Stack<Integer> items;

    public QueueByStack() {
        items = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!items.isEmpty()) {
            temp.push(items.pop());
        }
        temp.push(x);
        while (!temp.isEmpty()) {
            items.push(temp.pop());
        }
        size++;
    }

    public int pop() {
        if (empty()) throw new EmptyStackException();
        var item = items.pop();
        size--;
        return item;
    }

    public int peek() {
        if (empty()) throw new EmptyStackException();
        return items.peek();
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}