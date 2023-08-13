package trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private Node root;

    private static class Node {
        char value;
        Node[] children = new Node[26];
        boolean isEnd;

        public Node(char value) {
            this.value = value;
        }
    }

    public WordDictionary() {
        root = new Node(' ');
    }

    public void addWord(String word) {
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
        return search(word, root, 0);
    }


    public boolean search(String word, Node current, int index) {
        if (current == null) {
            return false;
        }
        if (index >= word.length()) {
            return current.isEnd;
        }
        int ch = word.charAt(index) - 'a';
        if (word.charAt(index) == '.') {
            for (var child : current.children) {
                if (search(word, child, index + 1)) {
                    return true;
                }
            }
        } else {
            Node nextNode = current.children[ch];

            return search(word, nextNode, index + 1);
        }

        return false;

    }
}
