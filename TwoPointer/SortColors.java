// import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] nums = { 2, 7, 0, 0, 1, 1 };
        int[] ans = solution.input(nums);
        System.out.println(ans);
    }

    public int[] input(int[] nums) {
        // Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int x = i, y = nums.length - 1;
            while (x <= y) {
                if (nums[i] > nums[x]) {
                    int temp = nums[i];
                    nums[i] = nums[x];
                    nums[x] = temp;
                }
                if (nums[i] > nums[y]) {
                    int temp = nums[i];
                    nums[i] = nums[y];
                    nums[y] = temp;
                }
                x++;
                y--;
            }
        }
        return nums;
    }
}
