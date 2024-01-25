public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] nums = { 3, 2, 0, 1 };
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i <= n; ++i) {
            ans ^= i;
            System.out.println(ans);
        }

        for (int idx = 0; idx < n; ++idx) {
            ans ^= nums[idx];
        }

        return ans;
    }
}
