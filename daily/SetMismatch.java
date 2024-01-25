
import java.util.HashSet;

public class SetMismatch {
    public static void main(String[] args) {
        SetMismatch solution = new SetMismatch();
        int[] nums = { 1, 2, 2, 4 };
        int[] ans = solution.input(nums);
        System.out.println(ans);
    }

    public int[] input(int[] nums) {
        int[] result = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            if (!set.add(num)) {
                // 發現重複的數字
                result[0] = num;
            }
            sum += num;
        }

        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        // 缺失的數字 = 預期數字的總和 - 實際數組中數字的總和 + 重複的數字
        result[1] = expectedSum - sum + result[0];

        return result;
    }
}
