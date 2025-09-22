package tree;

public class LowestCommonAncestor {

    static TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        if (node == p || node == q)
            return node;

        TreeNode leftSubTree = findLCA(node.left, p, q);
        TreeNode rightSubTree = findLCA(node.right, p, q);

        if (leftSubTree != null && rightSubTree != null) {
            return node;
        } else if (leftSubTree != null) {
            return leftSubTree;
        } else {
            return rightSubTree;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println("LCA of 0 & 5 is : " + findLCA(root, root.left.left, root.left.right.right));
        System.out.println("LCA of 0 & 9 is : " + findLCA(root, root.left.left, root.right.right));
    }
}
