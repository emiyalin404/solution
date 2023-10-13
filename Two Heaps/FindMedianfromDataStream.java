
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    public static void main(String[] args) {
        FindMedianfromDataStream Medianfrom = new FindMedianfromDataStream();
        Medianfrom.addNum(1);
        Medianfrom.addNum(2);
        System.out.println(Medianfrom.findMedian());
        Medianfrom.addNum(3);
        System.out.println(Medianfrom.findMedian());
    }

    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
}
