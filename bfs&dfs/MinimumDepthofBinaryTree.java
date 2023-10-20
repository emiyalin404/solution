public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        MinimumDepthofBinaryTree solution = new MinimumDepthofBinaryTree();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        int ans = solution.input(root);
        System.out.println(ans);
    }

    public int input(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = input(root.left);
        int right = input(root.right);
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

}
