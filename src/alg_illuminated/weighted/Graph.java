package alg_illuminated.weighted;


import java.util.*;
import java.util.stream.Collectors;


public class Graph {
    // Some algorithms need to traverse starting with root node, hence order is important
    private final Map<Node, Set<Node>> adjList = new LinkedHashMap<>();
    private final boolean isDirected;

    public Graph(Set<String> labels, boolean isDirected) {
        this.isDirected = isDirected;
        // create graph with these nodes, we'll add connections later
        labels.forEach(label -> adjList.putIfAbsent(new Node(label, 0), new HashSet<>()));
    }

    public void addConnection(String fromLabel, String toLabel, int weight) {
        adjList.get(new Node(fromLabel, 0)).add(new Node(toLabel, weight));
        // for non-directional graph, add connection in reverse direction as well
        if (!isDirected)
            adjList.get(new Node(toLabel, 0)).add(new Node(fromLabel, weight));
    }

    public Set<Tuple<Node, Node>> getAdjEdges(Node startingNode) {
        return adjList.get(new Node(startingNode.label, 0)).stream().map(node -> new Tuple<Node, Node>(startingNode, node)).collect(Collectors.toSet());
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

    public static class Node {
        public final String label;
        public final int weight;

        Node(String label, int weight) {
            this.label = label;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return weight == node.weight && Objects.equals(label, node.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label, weight);
        }

        @Override
        public String toString() {
            return label + ":" + weight;
        }

    }

}

class Tuple<X, Y> {
    public final X x;
    public final Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        return x.equals(tuple.x) && y.equals(tuple.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
