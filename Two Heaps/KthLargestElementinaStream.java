import java.util.PriorityQueue;

public class KthLargestElementinaStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public static void main(String[] args) {

        int k = 3;
        int[] nums = { 4, 5, 8, 2 };
        KthLargestElementinaStream KthLargest = new KthLargestElementinaStream(k, nums);
        System.out.print(KthLargest.add(3)); // 输出: 4
        System.out.print(KthLargest.add(5)); // 输出: 5
        System.out.print(KthLargest.add(10)); // 输出: 5
        System.out.print(KthLargest.add(9)); // 输出: 8
        System.out.print(KthLargest.add(4)); // 输出: 8
    }

    public KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (var n : nums)
            add(n);
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
