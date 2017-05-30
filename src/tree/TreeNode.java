package tree;

/**
 * Created by rpatel on 5/30/17.
 */
public class TreeNode {
    public int data;
    public TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("data=").append(data);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
