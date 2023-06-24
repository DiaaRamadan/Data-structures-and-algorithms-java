package stack;

class MinStack {

    private Node tail = null;

    public void push(int val) {

        int min = Math.min(val, tail == null ? Integer.MAX_VALUE : tail.min);
        Node node = new Node(min, val);

        if (tail == null)
            tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }

    }

    public void pop() {
        Node node = tail.prev;
        if (node != null) node.next = null;
        tail.prev = null;
        tail = node;
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return tail.min;
    }

    static class Node {
        int min;
        int val;
        Node next;
        Node prev;

        Node(int min, int val) {
            this.min = min;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */