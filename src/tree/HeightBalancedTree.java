package tree;

/**
 * Check if BST is height balanced:
 * A binary tree is balanced if for any two leaves the difference of the depth is at most 1
 */
public class HeightBalancedTree {

    public boolean isHeightBalanced(TreeNode root)
    {
        int maxHeight = maxLeafHeight(root);
        int minHeight = minLeafHeight(root);
        return (maxHeight - minHeight) <= 1;
    }

    public int maxLeafHeight(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        return Math.max(maxLeafHeight(root.left), maxLeafHeight(root.right)) + 1;
    }

    public int minLeafHeight(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        return Math.min(minLeafHeight(root.left), minLeafHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);

        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);

        HeightBalancedTree X = new HeightBalancedTree();
        System.out.println(X.isHeightBalanced(root));

    }
}
