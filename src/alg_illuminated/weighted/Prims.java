package alg_illuminated.weighted;

import java.util.*;
import java.util.stream.Collectors;

import static alg_illuminated.weighted.Graph.Node;

public class Prims {

    public static void main(String[] args) {
        Graph g = simpleGraph();
        System.out.println(g);
        simple(g);
    }

    static Graph simpleGraph() {
        Set<String> labelsStr = new LinkedHashSet<>(Arrays.asList("a", "b", "c", "d"));
        Graph g = new Graph(labelsStr, false);
        g.addConnection("a", "b", 1);
        g.addConnection("a", "d", 3);
        g.addConnection("a", "c", 4);
        g.addConnection("b", "d", 2);
        g.addConnection("c", "d", 5);
        return g;
    }

    /**
     * Runs in O(m*n) time, where m is #of edges and n is # of vertex in Graph g (same as Dijkstra's)
     * This is similar to Dijkstra's algorithm except we don't keep track of Dijkstra score as we iterate; instead
     * we build a new tree, a MST (minimum spanning tree)
     *
     * @param g
     */
    static void simple(Graph g) {
        // any node can be starting node
        Node startingNode = new Node("b", 0);
        Set<String> X = new HashSet<>();
        X.add(startingNode.label);
        Set<Tuple<Node, Node>> mstEdges = new HashSet<>();


        Set<Tuple<Node, Node>> adjEdges = g.getAdjEdges(startingNode);
        do {
            // find minimum edge among adjEdges, use of heap will reduce big O to (m + n)logn
            Tuple<Node, Node> minEdge = Collections.min(adjEdges, Comparator.comparing(edgeTuple -> edgeTuple.y.weight));

            // TODO add this vertex (i.e. minEdge.y) and edge to the graph (i.e. MST we're building)
            // e.g. new Node(minEdge.y.label, minEdge.y.weight)
            mstEdges.add(minEdge);

            // mark this vertex as added to the MST
            // (use only label of node, since weight of a node can be different in edge)
            X.add(minEdge.y.label);


            // get all edges from vertex in set X, excluding edges that begin and terminates within X

            adjEdges = X.stream().flatMap(nodeLabel ->
                            g.getAdjEdges(new Node(nodeLabel, 0)).stream()
                    )
                    // exclude edges already in set X
                    .filter(edgeTuple -> !(X.contains(edgeTuple.x.label) && X.contains(edgeTuple.y.label)))
                    .collect(Collectors.toSet());
        } while (!adjEdges.isEmpty());
        System.out.println("MST will include these vertices " + X);
        System.out.println("MST will have these edges " + mstEdges);
    }

}
