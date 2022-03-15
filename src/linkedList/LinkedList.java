package linkedList;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int indexOf(int value) {
        var current = first;
        int index = 0;
        while (current != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) == -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            first = first.next;
        }
        size--;
    }

    public void remove(int value){
        var current = first;
        Node prev = null;

        while(first!=null&&first.value==value)
            first=first.next;

        while(current != null){
            if(current.value == value){
                if (prev == null) prev = current.next;
                else prev.next = current.next;
            }else{
                prev = current;
            }
            current = current.next;
        }
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            previous.next = null;
            last = previous;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        var current = first;
        int index = 0;
        while (current != null) {
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void reverse() {
        var prev = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = prev ;
    }

    public void removeDuplicate(){
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        Node current = first;
        while(current != null){
            int currentValue = current.value;

            if (set.contains(currentValue)){
                prev.next = current.next;
            }else{
                set.add(currentValue);
                prev = current;
            }
            current = current.next;
        }
    }

    // public Node kth

    @Override
    public String toString() {
        var current = first;
        var string = "";
        while (current != null) {
            string += current.value + ",";
            current = current.next;
        }
        return string;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
