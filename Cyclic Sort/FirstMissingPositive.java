
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        int[] nums = { 7, 8, 9, 11, 12 };
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int[] nums) {
        int temp[] = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val > 0 && val <= nums.length) {
                temp[val] = 1;
            }
            // temp[nums[i]] = 1;
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }
        return temp.length;
    }
}
