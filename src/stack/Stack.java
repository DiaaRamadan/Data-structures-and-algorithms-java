package stack;

import java.util.ArrayList;

public class Stack<T> {

    ArrayList<T> items = new ArrayList<>();

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        T item = peek();
        items.remove(items.size() - 1);
        return item;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException();
        return items.get(items.size() - 1);
    }

    @Override
    public String toString(){
        return items.toString();
    }
}
