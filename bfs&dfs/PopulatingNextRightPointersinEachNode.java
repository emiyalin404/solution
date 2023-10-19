// import java.util.LinkedList;
// import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersinEachNode solution = new PopulatingNextRightPointersinEachNode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode ans = solution.input(root);
        System.out.println(ans);
    }

    public TreeNode input(TreeNode root) {
        TreeNode head = root;
        for (head = root; head != null;) {
            if (head.left == null) { // 如果 left 為 null 則表示現在沒有可連接的子節點
                return root;
            }
            TreeNode prev = null;
            TreeNode curr = head; // curr總是指向starting中每一層的起始節點

            while (curr != null) {
                if (prev != null) // 對於每個層級的第一個節點，prev 指向 null
                    prev.right.next = curr.left; // 將前一個節點右連接到目前左節點
                curr.left.next = curr.right; // 連接父節點的相同子節點
                prev = curr; // 將上一個節點和目前節點移動到下一個節點
                curr = curr.next;
            }
            head = head.left; // 將頭移至下一個級別
        }
        return root;
        // ==================================================
        // if (root == null)
        // return null;
        // Queue<TreeNode> q = new LinkedList<>();
        // q.offer(root);
        // while (!q.isEmpty()) {
        // TreeNode rightNode = null;
        // for (int i = q.size(); i > 0; i--) {
        // TreeNode cur = q.poll();
        // cur.next = rightNode;
        // rightNode = cur;
        // if (cur.right != null) {
        // q.offer(cur.right);
        // q.offer(cur.left);
        // }
        // }
        // }
        // return root;

    }
}
