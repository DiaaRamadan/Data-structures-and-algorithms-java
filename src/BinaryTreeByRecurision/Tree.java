package BinaryTreeByRecurision;

public class Tree {

    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
    Node root;

    public void insert(int value) {
        root = insert(value, root);
    }
    public boolean find(int value){
        return find(value, root);
    }
    public boolean isValid(){
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Node insert(int value, Node root) {
        if (root == null) return new Node(value);
        if (value < root.value) root.leftChild = insert(value, root.leftChild);
        else root.rightChild = insert(value, root.rightChild);
        return root;
    }
    private boolean find(int value, Node root) {
        boolean isFound;
        if (root == null) return false;
        if (value == root.value) return true;
        if(value < root.value) isFound = find(value, root.leftChild);
        else isFound = find(value, root.rightChild);
        return isFound;
    }
    private boolean isValid(Node root, int min, int max){
        if (root == null) return true;
        if (root.value < min || root.value > max) return  false;
        return isValid(root.leftChild, min, root.value - 1)
                && isValid(root.rightChild, root.value + 1, max);
    }

}
