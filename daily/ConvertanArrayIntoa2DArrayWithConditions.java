import java.util.ArrayList;
import java.util.List;

public class ConvertanArrayIntoa2DArrayWithConditions {
    public static void main(String[] args) {
        ConvertanArrayIntoa2DArrayWithConditions solution = new ConvertanArrayIntoa2DArrayWithConditions();
        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        List<List<Integer>> ans = solution.input(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> input(int[] nums) {
        int n = nums.length;
        List<List<Integer>> Arr = new ArrayList<>();
        int k = 0;
        while (k < n) {
            List<Integer> A = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!A.contains(nums[i]) && nums[i] != -1) {
                    A.add(nums[i]);
                    nums[i] = -1;
                    k++;
                }
            }
            Arr.add(A);
        }
        return Arr;
    }
}
