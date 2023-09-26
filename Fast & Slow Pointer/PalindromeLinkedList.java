public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);
        one.next = two;
        two.next = three;
        three.next = four;
        boolean ans = solution.input(one);
        System.out.println(ans);
    }

    public boolean input(ListNode head) {
        if (head == null && head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseList(slow);

        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    // if (head == null || head.next == null) {
    // return true;
    // }

    // ListNode fast = head;
    // ListNode slow = head;
    // while (fast != null && fast.next != null) {
    // fast = fast.next.next;
    // slow = slow.next;
    // }
    // slow = reverseList(slow);
    // while (slow != null) {
    // if (head.val != slow.val) {
    // return false;
    // }
    // head = head.next;
    // slow = slow.next;
    // }
    // return true;
    // }
    // private ListNode reverseList(ListNode head) {
    // ListNode prev = null;
    // ListNode curr = head;
    // while (curr != null) {
    // ListNode next = curr.next;
    // curr.next = prev;
    // prev = curr;
    // curr = next;
    // }
    // return prev;
    // }
}
