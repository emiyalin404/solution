
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
    public static void main(String[] args) {
        MaximumSizeSubarraySumEqualsk solution = new MaximumSizeSubarraySumEqualsk();
        int[] nums = { 1, -2, 5, -1, 3 };
        int k = 3;
        int[] ans = solution.input(nums, k);
        System.out.println(ans);
    }

    public int[] input(int[] nums, int k) {
        Map<Integer, Integer> sumindex = new HashMap<>();
        int maxLen = 0;
        int currSum = 0;
        int[] result = new int[0];
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum == k) {
                maxLen = i + 1;
                result = Arrays.copyOfRange(nums, 0, maxLen);
            }
            if (sumindex.containsKey(currSum - k)) {
                int startIndex = sumindex.get(currSum - k);
                if (i - startIndex > maxLen) {
                    maxLen = i - startIndex;
                    result = Arrays.copyOfRange(nums, startIndex + 1, i + 1);
                }
            }
            if (!sumindex.containsKey(currSum)) {
                sumindex.put(currSum, i);
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
