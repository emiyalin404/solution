
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        FindtheDuplicateNumber solution = new FindtheDuplicateNumber();
        int[] nums = { 1, 3, 4, 3, 2 };
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int[] nums) {
        int n = nums.length;
        int count[] = new int[n];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
            if (count[nums[i]] >= 2)
                return nums[i];
        }
        return -1;
    }
}
