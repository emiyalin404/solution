// import java.util.HashMap;
// import java.util.Map;

public class CountNicePairsinanArray {
    public static void main(String[] args) {
        CountNicePairsinanArray solution = new CountNicePairsinanArray();
        // int[] nums = { 42, 11, 1, 97 };
        int nums = 0;
        int ans = solution.rev(nums);
        System.out.println(ans);
        System.out.println();
    }

    private int rev(int n) {
        int rev = 0;
        while (n > 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;

        }
        return rev;
    }

    // private int rev(int n) {
    // int rev = 0;
    // while (n > 0) {
    // rev = (rev * 10) + (n % 10);
    // n /= 10;
    // }
    // return rev;
    // }

    // public int input(int[] nums) {
    // int total = 0;
    // Map<Integer, Integer> map = new HashMap<>();
    // for (int i = 0; i < nums.length; i++) {
    // int rev = rev(nums[i]);
    // int a = map.getOrDefault(nums[i] - rev, 0);
    // total = (total + a) % 1000000007;
    // map.put(nums[i] - rev, a + 1);
    // }
    // return total;
    // }
}
