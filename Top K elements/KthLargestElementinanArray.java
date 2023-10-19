import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        KthLargestElementinanArray solution = new KthLargestElementinanArray();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        int ans = solution.input(nums, k);
        System.out.println(ans);
    }

    public int input(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > nums.length - k + 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
