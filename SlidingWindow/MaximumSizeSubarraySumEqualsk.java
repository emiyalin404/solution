
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
    public static void main(String[] args) {
        MaximumSizeSubarraySumEqualsk solution = new MaximumSizeSubarraySumEqualsk();
        int[] nums = { 2, -1, 5, -2, 3 };
        int k = 3;
        int[] ans = solution.input(nums, k);
        System.out.println(ans);
    }

    public int[] input(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        int[] result = new int[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = i + 1;
                result = Arrays.copyOfRange(nums, 0, maxLen);
            }
            if (map.containsKey(sum - k)) {
                int index = map.get(sum - k);
                if (i - index > maxLen) {
                    maxLen = i - index;
                    result = Arrays.copyOfRange(nums, index + 1, i + 1);
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
        // Map<Integer, Integer> sumToIndex = new HashMap<>();
        // int maxLen = 0;
        // int currSum = 0;
        // int[] result = new int[0];
        // for (int i = 0; i < nums.length; i++) {
        // currSum += nums[i];
        // if (currSum == k) {
        // maxLen = i + 1;
        // result = Arrays.copyOfRange(nums, 0, maxLen);
        // }
        // if (sumToIndex.containsKey(currSum - k)) {
        // int startIndex = sumToIndex.get(currSum - k);
        // if (i - startIndex > maxLen) {
        // maxLen = i - startIndex;
        // result = Arrays.copyOfRange(nums, startIndex + 1, i + 1);
        // }
        // }
        // if (!sumToIndex.containsKey(currSum)) {
        // sumToIndex.put(currSum, i);
        // }
        // }
        // return result;
    }
}
