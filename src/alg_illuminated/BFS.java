package alg_illuminated;

import java.util.*;
import static alg_illuminated.Graph.Node;

public class BFS {
    private static final boolean isDirected = false;

    public static void main(String[] args) {
        Graph g = createGraphForCC();
        System.out.println(g);
        findConnectedComponents(g);
    }

    static Graph createGraphForBFS() {
        Set<String> labelsStr = new HashSet<>(Arrays.asList("s", "a", "b", "c", "d", "e"));
        Graph g = new Graph(labelsStr, isDirected);
        g.addConnection("s", "a");
        g.addConnection("s", "b");
        g.addConnection("a", "c");
        g.addConnection("b", "c");
        g.addConnection("b", "d");
        g.addConnection("c", "d");
        g.addConnection("c", "e");
        g.addConnection("e", "d");
        return g;
    }
    static void doBfs(Graph g) {
        Set<Node> exploredNodes = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("s");
        exploredNodes.add(new Node("s"));
        while(!queue.isEmpty()) {
            System.out.println("State of queue " + queue);
            String traverseNode = queue.poll();
            g.getAdjNodes(traverseNode).forEach(adjNode -> {
                if (!exploredNodes.contains(adjNode)) {
                    // this adjacent node is not explored yet
                    System.out.println("Exploring " + adjNode);
                    exploredNodes.add(adjNode);
                    queue.offer(adjNode.toString());
                }
            });
        }
    }

    static void shortestPathBfs(Graph g, String pathToNode) {
        Map<String, Integer> distance = new HashMap<>();
        Set<Node> exploredNodes = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("s");
        exploredNodes.add(new Node("s"));
        while(!queue.isEmpty()) {
            System.out.println("State of queue " + queue);
            String traverseNode = queue.poll();
            g.getAdjNodes(traverseNode).forEach(adjNode -> {
                if (!exploredNodes.contains(adjNode)) {
                    // this adjacent node is not explored yet
                    System.out.println("Exploring " + adjNode);
                    exploredNodes.add(adjNode);
                    // add distance of 1 for this node to the one that triggered this node's discovery (i.e. traverseNode)
                    Integer d = distance.getOrDefault(traverseNode, 0) + 1;
                    distance.put(adjNode.toString(), d);
                    queue.offer(adjNode.toString());
                }
            });
        }
        System.out.println("Distance " + distance);
    }

    static Graph createGraphForCC() {
        Set<String> labelsStr = new HashSet<>(Arrays.asList("1", "3", "5", "7", "9", "2", "4", "5", "8", "10", "6"));
        Graph g = new Graph(labelsStr, isDirected);
        g.addConnection("1", "3");
        g.addConnection("1", "5");
        g.addConnection("3", "5");
        g.addConnection("5", "7");
        g.addConnection("5", "9");
        g.addConnection("2", "4");
        g.addConnection("6", "8");
        g.addConnection("6", "10");
        return g;
    }
    static void findConnectedComponents(Graph g) {
        // finds connected components of a (undirected) graph
        Set<Node> exploredNodes = new HashSet<>();
        Set<Set<Node>> connectedComponents = new HashSet<>();
        // iterate over each node in this graph
        g.getAllNodes().forEach(node -> {
            Set<Node> thisCC = new HashSet<>();
            if (!exploredNodes.contains(node)) {
                // if not explored yet, do BFS on this node to explore all nodes connected to this node
                exploredNodes.add(node);
                Queue<String> queue = new LinkedList<>();
                queue.offer(node.toString());
                thisCC.add(node);
                while (!queue.isEmpty()) {
                    String tNode = queue.poll();
                    g.getAdjNodes(tNode).forEach(adjNode-> {
                        if (!exploredNodes.contains(adjNode)) {
                            exploredNodes.add(adjNode);
                            thisCC.add(adjNode);
                            queue.offer(adjNode.toString());
                        }
                    });
                }
            }
            connectedComponents.add(thisCC);
        });
        System.out.println("Connected components (nodes) are: " + connectedComponents);
    }

}
