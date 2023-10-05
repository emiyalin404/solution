import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        MaximumDepthofBinaryTree solution = new MaximumDepthofBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int ans = solution.input(root);
        System.out.println(ans);
    }

    public int input(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

            }
            count++;
        }
        return count;
    }
}
