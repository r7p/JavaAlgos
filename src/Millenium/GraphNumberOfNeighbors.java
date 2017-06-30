package Millenium;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a graph made of nodes, write a function getRange(Node, int) such that it returns
 * number of neighbors for given depth.
 *
 * S ---- a ---- c
 * |      |
 *  ----- b
 * e.g. For starting node S
 * getRange(S, 0) returns 1
 * getRange(S, 1) returns 3
 * getRange(S, 2) returns 4 (avoid dup neighbor)
 *
 *
 * Hint: watch out for dups
 *
 */
public class GraphNumberOfNeighbors {

    public static void main(String[] args) {
        Node s = new Node("Start");
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");

        s.addNeighbor(a);
        s.addNeighbor(b);

        a.addNeighbor(s);
        a.addNeighbor(b);
        a.addNeighbor(c);

        b.addNeighbor(s);
        b.addNeighbor(a);

        GraphNumberOfNeighbors x = new GraphNumberOfNeighbors();
        System.out.println("getRange(s, 0) should be 1.  It is " + x.getRange(s, 0));
        System.out.println("getRange(s, 1) should be 3.  It is " + x.getRange(s, 1));
        System.out.println("getRange(s, 2) should be 4.  It is " + x.getRange(s, 2));
    }


    int getRange(Node s, int range) {
        if (range < 0) {
            return 0;
        }
        Set<Node> seenNodes = new HashSet<>();
        seenNodes.add(s);
        getRangeRecurse(s, range, seenNodes);

        return seenNodes.size();
    }

    void getRangeRecurse(Node s, int range, Set<Node> seenNodes) {
        if (range == 0) {
            return;
        }
        Set<Node> nodes = unseenNeighbors(s.getNeighbors(), seenNodes);
        seenNodes.addAll(nodes);
        for(Node n:nodes) {
            getRangeRecurse(n, range - 1, seenNodes);
        }

    }

    Set<Node> unseenNeighbors(Set<Node> neighbors, Set<Node> seenNodes) {
        Set<Node> unseenNeighbors = new HashSet<>();
        for (Node n: neighbors) {
            if (!seenNodes.contains(n)) {
                unseenNeighbors.add(n);
            }
        }
        return unseenNeighbors;
    }

    static class Node {
        final String name;
        Set<Node> neighbors = new HashSet<>();

        Node(String name) {
            this.name = name;
        }

        public Set<Node> getNeighbors() {
            return neighbors;
        }
        public void addNeighbor(Node n) {
            neighbors.add(n);
        }
    }

}
