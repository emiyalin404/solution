public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int ans = solution.input(nums, target);
        System.out.println(ans);
    }

    public int input(int[] nums, int target) {

        int sum = 0, start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                min = Math.min(min, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
        // int sum = 0, start = 0;
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        // sum += nums[i];
        // while (sum >= target) {
        // min = Math.min(min, i - start + 1);
        // sum -= nums[start];
        // start++;
        // }
        // }
        // if (min == Integer.MAX_VALUE) {
        // return 0;
        // } else {
        // return min;
        // }
    }

}
