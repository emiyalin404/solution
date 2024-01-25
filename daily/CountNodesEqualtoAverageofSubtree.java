public class CountNodesEqualtoAverageofSubtree {
    public static void main(String[] args) {
        CountNodesEqualtoAverageofSubtree solution = new CountNodesEqualtoAverageofSubtree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(6);
        int ans = solution.input(root);
        System.out.println(ans);
    }

    int result = 0;

    public int input(TreeNode root) {
        dfs(root);
        return result;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        if (sum / count == node.val) {
            result++;
        }
        return new int[] { sum, count };
    }

    // public int input(TreeNode root) {
    // dfs(root);
    // return result;
    // }

    // private int dfs(TreeNode node) {
    // if (node == null) {
    // return 0;
    // }
    // int left = dfs(node.left);
    // int right = dfs(node.right);
    // int sum = left + right + node.val;
    // int count = left + right + 1; // 计算当前节点及其子节点的总数
    // if (Math.round((double) sum / count) == node.val) {
    // result++;
    // }
    // return count; // 返回当前节点及其子节点的总数
    // }
}
