package tree;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    static class Node {
        Node left, right;
        int data;

        public Node(int d) {
            this.left = null;
            this.right = null;
            this.data = d;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Node node = (Node) o;

            if (data != node.data)
                return false;
            if (left != null ? !left.equals(node.left) : node.left != null)
                return false;
            return right != null ? right.equals(node.right) : node.right == null;
        }

        @Override public int hashCode() {
            int result = left != null ? left.hashCode() : 0;
            result = 31 * result + (right != null ? right.hashCode() : 0);
            result = 31 * result + data;
            return result;
        }


        @Override public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("data=").append(data);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return String.valueOf(data);
        }
    }

    static void findPaths(Node node, List<Node> curPath) {
        if (node == null) {
            return;
        }
        curPath.add(node);
        if (node.left == null && node.right == null) {
            //we've reached leaf node
            System.out.println(curPath);
            return;
        }
        findPaths(node.left, new ArrayList<>(curPath));
        findPaths(node.right, new ArrayList<>(curPath));
        return;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(2);

        root.right.left = new Node(2);
        root.right.right = new Node(1);

        findPaths(root, new ArrayList<>());
    }
}
