public class MaximumDifferenceBetweenNodeandAncestor {
    public static void main(String[] args) {
        MaximumDifferenceBetweenNodeandAncestor solution = new MaximumDifferenceBetweenNodeandAncestor();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        int ans = solution.input(root);
        System.out.println(ans);

    }

    public int input(TreeNode root) {
        int[] m = { 0 };
        dfs(root, m);
        return m[0];
    }

    public int[] dfs(TreeNode root, int[] m) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        }

        int[] left = dfs(root.left, m);
        int[] right = dfs(root.right, m);

        int minVal = Math.min(root.val, Math.min(left[0], right[0]));
        int maxVal = Math.max(root.val, Math.max(right[1], right[1]));

        m[0] = Math.max(m[0], Math.max(Math.abs(minVal - root.val), Math.abs(maxVal -
                root.val)));

        return new int[] { minVal, maxVal };
    }

}
