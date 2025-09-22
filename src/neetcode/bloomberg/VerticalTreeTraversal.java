package neetcode.bloomberg;

import java.util.*;

public class VerticalTreeTraversal {

    /**
     * Time complexity O(N)
     * Space complexity is O(N)
     *
     * @param root
     * @return
     */
    static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Queue<Tuple<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, List<Integer>> columnTable = new HashMap<>();

        queue.offer(new Tuple<>(root, 0));
        int minCol = 0;
        int maxCol = 0;

        while (!queue.isEmpty()) {
            Tuple<TreeNode, Integer> nodeTuple = queue.poll();
            TreeNode node = nodeTuple.x;
            Integer column = nodeTuple.y;

            if (node != null) {
                columnTable.computeIfAbsent(column, k -> new ArrayList<>()).add(node.val);

                minCol = Math.min(minCol, column);
                maxCol = Math.max(maxCol, column);

                queue.offer(new Tuple<>(node.left, column  - 1));
                queue.offer(new Tuple<>(node.right, column  + 1));
            }
        }

        for (int i = minCol; i <= maxCol; i++) {
            output.add(columnTable.get(i));
        }

        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(8);
        root.left = left;
        root.right = right;

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);

        System.out.println(verticalOrder(root));
    }

    static class TreeNode {
        final int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Tuple<X, Y> {
        X x;
        Y y;
        Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

