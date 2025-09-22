package tree;

public class MaxSumPath {
    static int totalAnywhere;

    /**
     * Find max sum path in a binary tree.  Starting from root, find path to leaf that has max sum
     *
     * @param root
     * @return
     */
    static int maxSumPath(TreeNode root) {
        if (root == null)
            return 0;

        final int leftChildSum = maxSumPath(root.left);
        final int rightChildSum = maxSumPath(root.right);

        final int totalForThisNode = Math.max(leftChildSum, rightChildSum) + root.data;

        // we're checking if there is path (not necessary straight down) which has max sum
        totalAnywhere = Math.max(totalAnywhere, leftChildSum + rightChildSum + root.data);

        // This is max sum from root to leaf
        return totalForThisNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(15);

        System.out.println("Max sum from root to leaf: " + maxSumPath(root));
        System.out.println("Max sum anywhere: " + totalAnywhere);
    }
}
