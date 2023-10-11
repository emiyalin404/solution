import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesinanArray {
    public static void main(String[] args) {
        FindAllDuplicatesinanArray solution = new FindAllDuplicatesinanArray();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> ans = solution.input(nums);
        System.out.println(ans);
    }

    public List<Integer> input(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int result[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            result[nums[i]]++;
            if (result[nums[i]] >= 2) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
