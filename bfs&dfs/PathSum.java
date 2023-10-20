public class PathSum {
    public static void main(String[] args) {
        PathSum solution = new PathSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        boolean ans = solution.input(root, targetSum);
        System.out.println(ans);
    }

    public boolean input(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        return input(root.left, targetSum - root.val) || input(root.right, targetSum - root.val);
    }
}
