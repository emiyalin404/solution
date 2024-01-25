public class RangeSumofBST {
    public static void main(String[] args) {
        RangeSumofBST solution = new RangeSumofBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        int low = 7;
        int hight = 15;
        int ans = solution.input(root, low, hight);
        System.out.println(ans);
    }

    public int input(TreeNode root, int low, int hight) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= hight) {
            return root.val + input(root.left, low, hight) + input(root.right, low, hight);
        } else if (root.val < low) {
            return input(root.right, low, hight);
        } else {
            return input(root.left, low, hight);
        }
    }
}
