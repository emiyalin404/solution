
public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        boolean ans = solution.input(head);
        System.out.println(ans);
    }

    public boolean input(ListNode head) {
        ListNode fast = head;
        ListNode last = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            last = last.next.next;
            if (fast == last) {
                return true;
            }
        }
        return false;
    }
}
