import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        LeafSimilarTrees solution = new LeafSimilarTrees();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);
        boolean ans = solution.input(root1, root2);
        System.out.println(ans);
    }

    public boolean input(TreeNode root1, TreeNode root2) {
        return leafSimilar(root1, new ArrayList<>()).equals(leafSimilar(root2, new ArrayList<>()));
    }

    public List<Integer> leafSimilar(TreeNode root, List<Integer> l1) {
        if (root == null) {
            return l1;
        }
        if (root.left == null && root.right == null) {
            l1.add(root.val);
        }
        if (root.left != null) {
            leafSimilar(root.left, l1);
        }
        if (root.right != null) {
            leafSimilar(root.right, l1);
        }

        return l1;

    }
}
