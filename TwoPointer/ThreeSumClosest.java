import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        int[] nums = { -1, 2, 1, 4 };
        int target = 1;
        int ans = solution.input(nums, target);
        System.out.println(ans);

    }

    public int input(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(ans))
                    ans = target - sum;

                if (sum > target)
                    r--;
                else
                    l++;
            }
        }
        return (target - ans);
    }
}
