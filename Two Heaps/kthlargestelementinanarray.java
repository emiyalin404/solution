import java.util.PriorityQueue;

public class kthlargestelementinanarray {
    public static void main(String[] args) {
        kthlargestelementinanarray solution = new kthlargestelementinanarray();
        int[] nums = { 3, 2, 1, 5, 6, 2 };
        int k = 2;
        int ans = solution.input(nums, k);
        System.out.println(ans);
    }

    public int input(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int t = k;
        int i = 0;
        while (t > 0) {
            pq.add(nums[i++]);
            t--;
        }
        int currentMax = 0;
        for (i = k; i < nums.length; i++) {
            currentMax = pq.peek();
            if (currentMax < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int t = k;
        // int i = 0;
        // while (t-- > 0) {
        // pq.add(nums[i++]);
        // }
        // int currentMax = 0;
        // for (i = k; i < nums.length; i++) {
        // currentMax = pq.peek();
        // if (currentMax < nums[i]) {
        // pq.poll();
        // pq.add(nums[i]);
        // }
        // }
        // return pq.peek();
    }
}
