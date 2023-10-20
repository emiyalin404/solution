public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        RecoverBinarySearchTree solution = new RecoverBinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        System.out.println(root);
        solution.input(root);
    }

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode pre = null;

    public void input(TreeNode root) {
        traval(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        System.out.println(root);
    }

    public void traval(TreeNode root) {
        if (root == null) {
            return;
        }
        traval(root.left);
        if (first == null && (pre == null || pre.val >= root.val)) {
            first = pre;
        }
        if (first != null && pre.val >= root.val) {
            second = root;
        }
        pre = root;
        traval(root.right);
    }

    // public void input(TreeNode root) {
    // if (root == null) {
    // return;
    // }
    // inoder(root);
    // int temp = first.val;
    // first.val = second.val;
    // second.val = temp;
    // }

    // private void inoder(TreeNode root) {
    // if (root == null) {
    // return;
    // }
    // inoder(root.left);
    // if (first == null && (pre == null || pre.val >= root.val)) {
    // first = pre;
    // }
    // if (first != null && pre.val >= root.val) {
    // second = root;
    // }
    // pre = root;
    // inoder(root.right);
    // }
}
