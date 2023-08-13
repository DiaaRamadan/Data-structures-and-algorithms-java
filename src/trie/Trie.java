package trie;

public class Trie {

    private Node root;

    private static class Node {
        char value;
        Node[] children = new Node[26];
        boolean isEnd;

        public Node(char value) {
            this.value = value;
        }
    }

    public Trie() {
        root = new Node(' ');
    }

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null)
                current.children[index] = new Node(ch);
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            Node child = current.children[index];
            if (child != null) {
                current = child;
            } else {
                return false;
            }
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            Node child = current.children[index];
            if (child != null) {
                current = child;
            } else {
                return false;
            }
        }
        return true;
    }
}
