public class LinkedListCycleII {
    public static void main(String[] args) {
        LinkedListCycleII solution = new LinkedListCycleII();
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;
        ListNode ans = solution.detectCycle(one);
        if (ans != null) {
            System.out.println(ans.val);
        } else {
            System.out.println("No cycle");
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        // ListNode fast = head;
        // ListNode last = head;
        // while (fast != null && last != null) {
        // last = last.next;
        // fast = fast.next.next;
        // if (last == fast) {
        // break;
        // }
        // }
        // if(fast==null||fast.next==null){
        // return null;
        // }
        // last = head;
        // while (last != fast) {
        // fast = fast.next;
        // last = last.next;
        // }

        // return last; // 返回循环的起始节点
    }
}
