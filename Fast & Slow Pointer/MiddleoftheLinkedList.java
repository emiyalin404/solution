// import java.util.LinkedList

public class MiddleoftheLinkedList {
    public static void main(String[] args) {
        MiddleoftheLinkedList solution = new MiddleoftheLinkedList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode ans = solution.input(one);
        System.out.println(ans);
    }

    public ListNode input(ListNode head) {
        ListNode fast = head;
        ListNode last = head;
        while (fast != null && fast.next != null) {
            last = last.next;
            fast = fast.next.next;

        }
        return last;
    }
}
