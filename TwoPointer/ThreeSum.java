import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ans = solution.input(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> input(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}
