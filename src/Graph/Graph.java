package Graph;

import java.util.*;

public class Graph {

    private record Node(String label) {
        @Override
        public String toString() {
            return label;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();
    private final Map<Node, List<Node>> adjacencyNodes = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyNodes.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyNodes.get(fromNode).add(toNode);

    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null) return;

        for (var n : adjacencyNodes.keySet())
            adjacencyNodes.get(n).remove(node);

        adjacencyNodes.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null) return;

        adjacencyNodes.get(fromNode).remove(toNode);
    }

    public void print() {
        for (var source : adjacencyNodes.keySet()) {
            var targets = adjacencyNodes.get(source);
            if (!targets.isEmpty()) System.out.println(source + " is connected to " + targets);
        }
    }

    public void traverseDepthFirstIter(String label) {
        Node node = nodes.get(label);
        if (Objects.isNull(node)) return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (visited.contains(current)) continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour : adjacencyNodes.get(current))
                if (!visited.contains(neighbour)) stack.push(neighbour);
        }
    }

    public void traverseDepthFirstRec(String label) {
        Node node = nodes.get(label);
        if (Objects.isNull(node)) return;
        traverseDepthFirstRec(node, new HashSet<>());
    }

    public void traverseBreadthFirst(String label) {
        Node node = nodes.get(label);
        if (Objects.isNull(node)) return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if (visited.contains(current)) continue;

            System.out.println(current);
            visited.add(current);

            for (var neighbour : adjacencyNodes.get(current))
                if (!visited.contains(neighbour)) queue.add(neighbour);
        }
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (var node : adjacencyNodes.get(root))
            if (!visited.contains(node)) traverseDepthFirstRec(node, visited);
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values())
            topologicalSort(node, visited, stack);

        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty()) sorted.add(stack.pop().label);

        return sorted;

    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node)) return;
        visited.add(node);

        for (var neighbour : adjacencyNodes.get(node))
            topologicalSort(neighbour, visited, stack);

        stack.push(node);
    }

}
