public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        int ans = solution.input(nums, k);
        System.out.println(ans);
    }

    public int input(int[] nums, int k) {
        int fast = 0, last = 1, j = 0;
        for (int i = 0; i < nums.length; i++) {
            last = last * nums[i];
            while (last >= k && j < i) {
                last /= nums[j];
                j++;
            }
            if (last < k) {
                fast += (i - j + 1);
            }
        }
        return fast;
    }
}
