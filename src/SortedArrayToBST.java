import java.util.*;
import java.util.Stack;

/**
 * Created by rpatel on 5/22/17.
 */
public class SortedArrayToBST {

    class Node {
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
    }

    Node sortedArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    /**
     *
     * Root, Left, Right
     *
     * @param node
     */
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void preOrderIterative(Node node) {
        if (node == null) {
            return;
        }
        java.util.Stack<Node> aStack = new Stack<>();
        aStack.push(node);
        while (!aStack.empty()) {
            node = aStack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                aStack.push(node.right);
            }
            if (node.left != null) {
                aStack.push(node.left);
            }
        }
    }

    /**
     * Left (last leaf node on left), Parent, Right
     *
     * Prints BST in sorted order (Ascending)
     * This is NOT BFS!  This goes to left most last leaf node, then print parent, then parent's right.
     * @param node
     */
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);

    }

    void inOrderIterative(Node node) {
        java.util.Stack<Node> aStack = new Stack<>();
        while (!aStack.empty() || node != null) {
            if (node != null) {
                aStack.push(node);
                node = node.left;
            } else {
                node = aStack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    void levelOrderOrBFS(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        SortedArrayToBST tree = new SortedArrayToBST();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        Node root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
        System.out.println("");
        tree.preOrderIterative(root);
        System.out.println("");
        System.out.println("InOrder traversal of constructed BST");
        tree.inOrder(root);
        System.out.println("");
        tree.inOrderIterative(root);
        System.out.println("");
        System.out.println("Breadth First OR Level Order traversal of constructed BST");
        tree.levelOrderOrBFS(root);
    }
}
