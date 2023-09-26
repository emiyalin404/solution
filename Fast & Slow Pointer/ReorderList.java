public class ReorderList {
    public static void main(String[] args) {
        ReorderList solution = new ReorderList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        ListNode ans = solution.input(one);
        System.out.println(ans);
    }

    public ListNode input(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode forw = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        while (prev != null) {
            ListNode p = head.next;
            ListNode q = prev.next;
            head.next = prev;
            prev.next = p;
            prev = q;
            head = p;
        }

        // ListNode slow = head;
        // ListNode fast = head;
        // while (fast != null && fast.next != null) {
        // slow = slow.next;
        // fast = fast.next.next;
        // }
        // ListNode prev = null;
        // while (slow != null) {
        // ListNode temp = slow.next;
        // slow.next = prev;
        // prev = slow;
        // slow = temp;
        // }
        // ListNode p1 = head;
        // ListNode p2 = prev;
        // while (p1 != null && p2 != null) {
        // ListNode next1 = p1.next;
        // ListNode next2 = p2.next;
        // p1.next = p2;
        // p2.next = next1;
        // p1 = next1;
        // p2 = next2;
        // }
        return head;
    }
}
