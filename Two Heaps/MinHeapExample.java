import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(9);
        minHeap.add(1);
        minHeap.add(6);

        int minValue = minHeap.poll();
        System.out.println("min value: " + minValue);
    }
}
