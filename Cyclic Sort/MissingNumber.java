// import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] nums = { 3, 0, 2, 4, 8, 6, 7, 1 };
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int[] nums) {
        // int n = nums.length;
        // int sum = 0;
        // for (var each : nums) {
        // sum += each;
        // }
        // return ((n * (n + 1) / 2) - sum);

        // Arrays.sort(nums);
        int j = 0, n = nums.length;
        while (j < n) {
            int a = nums[j];
            if (a < j && nums[j] != nums[a]) {
                int temp = nums[a];
                nums[a] = nums[j];
                nums[j] = temp;
            } else {
                j++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
