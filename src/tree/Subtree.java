package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Subtree {

    static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // find a node on root tree that is same as on subRoot's root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final TreeNode thisNode = queue.poll();
            if (thisNode.data == subRoot.data)
                if (isSameTree(thisNode, subRoot))
                    return true;
            if (thisNode.left != null)
                queue.offer(thisNode.left);
            if (thisNode.right != null)
                queue.offer(thisNode.right);
        }

        return false;
    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.data != q.data)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println("Should return true: " + isSubtree(root, subRoot));

        TreeNode root2 = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);
        System.out.println("Should return false: " + isSubtree(root2, subRoot));
    }
}
