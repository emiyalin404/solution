import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AmountofTimeforBinaryTreetoBeInfected {
    public static void main(String[] args) {
        AmountofTimeforBinaryTreetoBeInfected solution = new AmountofTimeforBinaryTreetoBeInfected();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        int start = 3;
        int ans = solution.input(root, start);
        System.out.println(ans);
    }

    public int input(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(root, null, graph);
        int res = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int id = queue.poll();
                visited.add(id);
                for (int next : graph.get(id)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
            res++;
        }
        return res;
    }

    private void dfs(TreeNode root, TreeNode prev, Map<Integer, List<Integer>> graph) {
        if (root == null)
            return;
        graph.put(root.val, new ArrayList<>());
        if (prev != null) {
            graph.get(root.val).add(prev.val);
        }
        if (root.left != null) {
            dfs(root.left, root, graph);
            graph.get(root.val).add(root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, root, graph);
            graph.get(root.val).add(root.right.val);
        }
    }
}
