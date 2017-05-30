package tree;

/**
 * Check if BST is balanced
 */
public class CheckBalanced {

    int isBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = isBalanced(root.left);
        return leftH++;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);

        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);

        CheckBalanced X = new CheckBalanced();
        int balanced = X.isBalanced(root);
        System.out.println(balanced);

    }
}
