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

    List<Integer> list = new ArrayList<>();

    public List<Integer> input(TreeNode root) {
        if (root != null) {
            input(root.left);
            list.add(root.val);
            input(root.right);
        }
        return list;
    }

}
