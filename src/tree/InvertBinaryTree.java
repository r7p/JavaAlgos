package tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    static void invertTheBinaryTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final TreeNode thisNode = queue.poll();

            // Do the swap of left & right node
            final TreeNode leftNode = thisNode.left;
            thisNode.left = thisNode.right;
            thisNode.right = leftNode;

            if (thisNode.left != null)
                queue.offer(thisNode.left);
            if (thisNode.right != null)
                queue.offer(thisNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        invertTheBinaryTree(root);
        System.out.println("Inverted binary tree " + root);
    }
}
