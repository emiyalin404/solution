import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        ThreeSumSmaller solution = new ThreeSumSmaller();
        int[] nums = { -2, 0, 1, 3 };
        int target = 2;
        int ans = solution.input(nums, target);
        System.out.println(ans);
    }

    public int input(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    count += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }
}
