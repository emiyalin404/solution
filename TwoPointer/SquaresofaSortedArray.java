public class SquaresofaSortedArray {
    public static void main(String[] args) {
        SquaresofaSortedArray solution = new SquaresofaSortedArray();
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] ans = solution.input(nums);
        System.out.println(ans);
    }

    public int[] input(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i > 0; i--) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;

    }
}
