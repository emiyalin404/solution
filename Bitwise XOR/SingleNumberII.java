import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    public static void main(String[] args) {
        SingleNumberII solution = new SingleNumberII();
        int[] nums = { 2, 2, 3, 2 };
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int e : map.keySet()) {
            if (map.get(e) == 1) {
                result = e;
            }
        }
        return result;
    }
}
