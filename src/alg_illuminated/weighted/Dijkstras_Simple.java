package alg_illuminated.weighted;

import java.util.*;
import java.util.stream.Collectors;

import static alg_illuminated.weighted.Graph.Node;

public class Dijkstras_Simple {

    public static void main(String[] args) {
        Graph g = simpleGraph();
        System.out.println(g);
        simple(g);
    }

    static Graph simpleGraph() {
        Set<String> labelsStr = new LinkedHashSet<>(Arrays.asList("s", "v", "w", "t"));
        Graph g = new Graph(labelsStr, true);
        g.addConnection("s", "v", 1);
        g.addConnection("s", "w", 4);
        g.addConnection("v", "w", 2);
        g.addConnection("v", "t", 6);
        g.addConnection("w", "t", 3);
        return g;
    }

    static Graph cyclicGraph() {
        Set<String> labelsStr = new LinkedHashSet<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6"));
        Graph g = new Graph(labelsStr, true);
        g.addConnection("0", "1", 5);
        g.addConnection("0", "3", 21);
        g.addConnection("1", "2", 40);
        g.addConnection("2", "3", 13);
        g.addConnection("3", "5", 41);
        g.addConnection("2", "4", 19);
        g.addConnection("4", "5", 32);
        g.addConnection("4", "6", 14);
        g.addConnection("5", "6", 8);
        return g;
    }

    static void simple(Graph g) {
        Node root = new Node("1", 0);
        Map<Node, Integer> distance = new HashMap<>();
        distance.put(root, 0);

        Set<Tuple<Node, Node>> adjEdges = g.getAdjEdges(root);
        do {
            // find minimum edge among adjEdges
            Tuple<Node, Node> minEdge = null;
            int minEdgeDistance = Integer.MAX_VALUE;
            for(Tuple<Node, Node> tuple: adjEdges) {
                int thisEdgeDistance = distance.get(tuple.x) + tuple.y.weight;
                if (thisEdgeDistance < minEdgeDistance) {
                    minEdgeDistance = thisEdgeDistance;
                    minEdge = tuple;
                }
            }


            distance.put(minEdge.y, minEdgeDistance);
            // use only label of node, since weight of a node can be different in edge
            Set<String> X = distance.keySet().stream().map(node -> node.label).collect(Collectors.toSet());

            adjEdges = distance.keySet().stream().flatMap(node ->
                    g.getAdjEdges(node).stream()
                    )
                    // exclude edges already in set X
                    .filter(edgeTuple -> !(X.contains(edgeTuple.x.label) && X.contains(edgeTuple.y.label)))
                    .collect(Collectors.toSet());
        } while (!adjEdges.isEmpty());
        System.out.println("Minimum distance is " + distance);
    }

}
