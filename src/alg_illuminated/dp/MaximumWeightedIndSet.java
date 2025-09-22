package alg_illuminated.dp;


import java.util.*;

/**
 * Maximum Weighted Independent Set (MWIS): Finding set of nodes that are node connected AND have maximum combined 'weight' between them
 *
 */
public class MaximumWeightedIndSet {

    static int[] findMWIS(Graph graph) {
        List<Node> allNodes = graph.getAllNodes();
        int[] weights = new int[allNodes.size() + 1];

        weights[0] = 0;
        weights[1] = allNodes.get(0).weight;

        // Note the relationship between weights' index and allNodes' index: it is i -> i -1
        // In the book, nodes (i.e. allNodes here) is indexed starting 1, whereas here it is 0
        for (int i = 2; i <= allNodes.size(); i++) {
            // max of case 1 and case 2
            weights[i] = Math.max(weights[i - 1], weights[i - 2] + allNodes.get(i - 1).weight);
        }

        return weights;
    }

    static Set<Node> reconstruction(Graph graph, int[] weights) {
        List<Node> allNodes = graph.getAllNodes();
        Set<Node> result = new HashSet<>();
        int i = weights.length - 1;
        while (i >= 2) {
            if (weights[i - 1] >= weights[i - 2] + allNodes.get(i - 1).weight) {
                // Case 1 where this node is not part of optimal solution
                i = i - 1;
            } else {
                // Case 2 where current node is part of optimal solution
                result.add(allNodes.get(i - 1));
                i = i - 2; // exclude node before current node as it cannot be part of the solution
            }
        }

        if (i == 1) {
            result.add(allNodes.get(0));
        }

        return result;
    }

    public static void main(String[] args) {
        // labels are not used in computation; its only weight that matters
        int[] weights = {3, 2, 1, 6, 4, 5};
        Graph g = new Graph(weights);
        int[] weightResult = findMWIS(g);
        System.out.println(Arrays.toString(weightResult));

        // Note: this print node's weight, not label as it doesn't have one
        System.out.println(reconstruction(g, weightResult));
    }
}

class Graph {
    // we would like to maintain insertion order of nodes
    final List<Node> nodes = new LinkedList<>();
    Graph(int[] weights) {
        for(int w: weights) {
            nodes.add(new Node(w));
        }
    }

    List<Node> getAllNodes() {
       return Collections.unmodifiableList(nodes);
    }
}

class Node {
    final int weight;
    Node(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.valueOf(weight);
    }
}