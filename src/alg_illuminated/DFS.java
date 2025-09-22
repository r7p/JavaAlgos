package alg_illuminated;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static alg_illuminated.Graph.Node;

public class DFS {
    public static void main(String[] args) {
/*        Graph g = createGraphForDFS();
        System.out.println(g);
        doDfs(g);
        System.out.println("\n");
        recursiveDfs(g, "s", new HashSet<>());*/
        System.out.println("\n");
        topologicalSort(createDirectedGraph());
    }

    static Graph createGraphForDFS() {
        Set<String> labelsStr = new HashSet<>(Arrays.asList("s", "a", "b", "c", "d", "e"));
        Graph g = new Graph(labelsStr, false);
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

    static void doDfs(Graph g) {
        Set<String> exploredNodes = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push("s");
        while (!stack.isEmpty()) {
            String tNode = stack.pop();
            if (!exploredNodes.contains(tNode)) {
                exploredNodes.add(tNode);
                System.out.println("Exploring node " + tNode);
                g.getAdjNodes(tNode).forEach(adjNode -> {
                    stack.push(adjNode.toString());
                });
            }
        }
    }

    static void recursiveDfs(Graph g, String nodeLabel, Set<String> exploredNodes) {
        exploredNodes.add(nodeLabel);
        System.out.println("Exploring node " + nodeLabel);
        g.getAdjNodes(nodeLabel).forEach(node -> {
            if (!exploredNodes.contains(node.toString())) {
                recursiveDfs(g, node.toString(), exploredNodes);
            }
        });
    }

    static Graph createDirectedGraph() {
        // Order of insertion of node while creating directed graph is important since we need to iterate over nodes
        // starting with root node (e.g. "s")
        Set<String> labelsStr = new LinkedHashSet<>(Arrays.asList("s", "v", "w", "t"));
        Graph g = new Graph(labelsStr, true);
        g.addConnection("s", "v");
        g.addConnection("s", "w");
        g.addConnection("v", "t");
        g.addConnection("w", "t");
        // following 3 edges creates a cycle
      /*g.addConnection("t", "a");
        g.addConnection("a", "b");
        g.addConnection("b", "t");*/
        return g;
    }

    static void topologicalSort(Graph g) {
        // iterate over all nodes in this graph
        Set<String> exploredNodes = new HashSet<>();
        AtomicInteger curLabel = new AtomicInteger(g.getAllNodes().size());
        Map<String, Integer> labels = new HashMap<>();

        g.getAllNodes().forEach(node -> {
            if (!exploredNodes.contains(node.toString())) {
                dfsTopological(g, node.toString(), exploredNodes, curLabel, labels);
            }
        });
        // if node "s" has value 1, then this graph is topologically sorted
        System.out.println("Labels are " + labels);
    }

    static void dfsTopological(Graph g, String nodeLabel, Set<String> exploredNodes, AtomicInteger curLabel, Map<String, Integer> labels) {
        exploredNodes.add(nodeLabel);
        System.out.println("Exploring node " + nodeLabel);
        for (Node node: g.getAdjNodes(nodeLabel)) {
            if (!exploredNodes.contains(node.toString())) {
                dfsTopological(g, node.toString(), exploredNodes, curLabel, labels);
            }
        }
        labels.put(nodeLabel, curLabel.intValue());
        System.out.println("Cur Label is " + curLabel.decrementAndGet());
    }
}
