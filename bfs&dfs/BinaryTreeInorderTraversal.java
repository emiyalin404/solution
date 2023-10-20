import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> ans = solution.input(root);
        System.out.println(ans);
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> input(TreeNode root) {
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root) {
        if (root != null) {
            traversal(root.left);
            res.add(root.val);
            traversal(root.right);
        }
    }
}
