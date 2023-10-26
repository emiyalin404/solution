import java.util.HashSet;

public class MaximumXORofTwoNumbersinanArray {
    public static void main(String[] args) {
        MaximumXORofTwoNumbersinanArray solution = new MaximumXORofTwoNumbersinanArray();
        int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int[] nums) {
        int result = 0;
        int mask = 0;
        int i = 31;
        while (i >= 0) {
            mask = mask | (1 << i);
            int candidate = result | (1 << i);

            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            for (int prefix : set) {
                if (set.contains(candidate ^ prefix)) {
                    result = candidate;
                    break;
                }
            }
            i--;
        }
        return result;
    }
}
