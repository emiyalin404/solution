import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII solution = new BinaryTreeLevelOrderTraversalII();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> ans = solution.input(root);
        System.out.println(ans);
    }

    public List<List<Integer>> input(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Stack<List<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            stack.push(currentLevel);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
