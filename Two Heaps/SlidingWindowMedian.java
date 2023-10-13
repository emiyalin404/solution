
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        SlidingWindowMedian solution = new SlidingWindowMedian();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        double[] ans = solution.input(nums, k);
        System.out.println(ans);
    }

    public double[] input(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int p = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int i = 0, j = 0;
        while (j < nums.length) {
            if (max.size() <= min.size()) {
                min.add(nums[j]);
                max.add(min.poll());
            } else {
                max.add(nums[j]);
                min.add(max.poll());
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (max.size() == min.size()) {
                    result[p++] = (double) ((long) max.peek() + (long) min.peek()) / 2.0;
                } else {
                    result[p++] = (double) max.peek();
                }
                if (!max.remove(nums[i])) {
                    min.remove(nums[i]);
                }
                i++;
                j++;
            }
        }
        return result;
    }
}
