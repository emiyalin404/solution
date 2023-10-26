public class SingleNumberIII {
    public static void main(String[] args) {
        SingleNumberIII solution = new SingleNumberIII();
        int[] nums = { 1, 2, 1, 3, 2, 4 };
        int[] ans = solution.input(nums);
        System.out.println(ans);
    }

    public int[] input(int[] nums) {
        int[] res = new int[2];
        int a = 0, b = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }

        temp = (temp & -temp);

        for (int i = 0; i < nums.length; i++) {
            if ((temp & nums[i]) > 0) {
                a = a ^ nums[i];
            } else {
                b = b ^ nums[i];
            }
        }
        res[0] = a;
        res[1] = b;
        return res;

        // int[] res = new int[2];
        // int a = 0, b = 0;
        // int temp = 0;
        // for (int i = 0; i < nums.length; i++) {
        // temp ^= nums[i];
        // }
        // temp = (temp & -temp);
        // for (int i = 0; i < nums.length; i++) {
        // if ((temp & nums[i]) > 0) {
        // a = a ^ nums[i];
        // } else {
        // b = b ^ nums[i];
        // }
        // }
        // res[0] = a;
        // res[1] = b;
        // return res;
    }
}
