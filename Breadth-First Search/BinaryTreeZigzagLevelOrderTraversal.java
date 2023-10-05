import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = solution.input(root);
        for (List<Integer> each : ans) {
            System.out.println(each);
        }
    }

    public List<List<Integer>> input(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            Stack<Integer> tempStack = new Stack<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode current = queue.poll();
                if (zigzag) {
                    tempStack.push(current.val);
                } else {
                    currentLevel.add(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            while (!tempStack.isEmpty()) {
                currentLevel.add(tempStack.pop());
            }
            result.add(currentLevel);
            zigzag = !zigzag;
        }
        return result;
    }
}
