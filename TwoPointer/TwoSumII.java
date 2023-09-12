public class TwoSumII {
    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();
        int[] nums = { 2, 3, 4, 5, 6, 7 };
        int target = 8;
        int[] ans = solution.input(nums, target);
        System.out.println(ans);
    }

    public int[] input(int[] nums, int target) {
        int n = nums.length;
        int slow = 0;
        int fast = n - 1;
        while (slow < fast) {
            if (nums[slow] + nums[fast] == target) {
                return new int[] { slow + 1, fast + 1 };
            } else if (nums[slow] + nums[fast] < target) {
                slow++;
            } else {
                fast--;
            }
        }
        return new int[] { -1, -1 };
    }
}
