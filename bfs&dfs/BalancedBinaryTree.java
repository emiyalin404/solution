public class BalancedBinaryTree {
    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        boolean ans = solution.isBalanced(root);
        System.out.println(ans);
    }

    public boolean isBalanced(TreeNode root) {
        return traval(root) != -1;
    }

    public int traval(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traval(root.left);
        if (left == -1) {
            return -1;
        }
        int right = traval(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
