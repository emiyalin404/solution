public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean ans = solution.traval(root);
        System.out.println(ans);
    }

    public boolean traval(TreeNode root) {
        return trava(root, null, null);
    }

    public boolean trava(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return trava(root.left, min, root.val) && trava(root.right, root.val, max);
    }
}
