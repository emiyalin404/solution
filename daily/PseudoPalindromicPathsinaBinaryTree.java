public class PseudoPalindromicPathsinaBinaryTree {
    public static void main(String[] args) {
        PseudoPalindromicPathsinaBinaryTree solution = new PseudoPalindromicPathsinaBinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        int ans = solution.input(root);
        System.out.println(ans);
    }

    int ans = 0;

    public int input(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;

    }

    public void dfs(TreeNode root, int count) {
        if (root == null)
            return;
        count ^= 1 << (root.val - 1);
        dfs(root.left, count);
        dfs(root.right, count);
        if (root.left == null && root.right == null && (count & (count - 1)) == 0)
            ans++;
    }
}
