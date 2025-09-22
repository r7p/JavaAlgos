package alg_illuminated;


import java.util.*;
import java.util.stream.Collectors;


public class Graph {
    // Some algorithms need to traverse starting with root node, hence order is important
    private final Map<Node, Set<Node>> adjList = new LinkedHashMap<>();
    private final boolean isDirected;

    public Graph(Set<String> labels, boolean isDirected) {
        this.isDirected = isDirected;
        // create graph with these nodes, we'll add connections later
        labels.forEach(label -> adjList.putIfAbsent(new Node(label), new HashSet<>()));
    }

    public void addConnection(String fromLabel, String toLabel) {
        adjList.get(new Node(fromLabel)).add(new Node(toLabel));
        // for non-directional graph, add connection in reverse direction as well
        if (!isDirected)
            adjList.get(new Node(toLabel)).add(new Node(fromLabel));
    }

    public Set<Node> getAdjNodes(String nodeLabel) {
        return adjList.get(new Node(nodeLabel));
    }

    public Set<Node> getAllNodes() {
        return adjList.keySet();
    }

    @Override
    public String toString() {
        String adjListStr = adjList.entrySet().stream()
                .map(e ->
                        e.getKey().toString() + ": " +
                                e.getValue().stream().map(Node::toString).collect(Collectors.joining(", "))).collect(Collectors.joining("\n"));
        return "Graph{\n" +
                adjListStr +
                "\n}";
    }


    static public class Node {
        private final String label;

        Node(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return label.equals(node.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
