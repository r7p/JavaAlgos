package tree;

/**
 * Created by rpatel on 5/30/17.
 */
public class WeightBalanced {
    /*
 * Given a TreeNode root, return the height of the tree under it if it is
 * balanced. Return -1 otherwise.
 */
    public int getBalancedHeight(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int leftBalancedHeight = getBalancedHeight(root.left);
        int rightBalancedHeight = getBalancedHeight(root.right);

        if ((Math.abs(leftBalancedHeight - rightBalancedHeight) > 1) ||
            (leftBalancedHeight == -1) || (rightBalancedHeight == -1))
        {
            return -1;
        }

        return Math.max(leftBalancedHeight, rightBalancedHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);

        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);

        WeightBalanced X = new WeightBalanced();
        System.out.println(X.getBalancedHeight(root));

    }
}
