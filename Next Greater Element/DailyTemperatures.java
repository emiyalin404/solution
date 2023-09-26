import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] ans = solution.input(nums);
        for (int each : ans) {
            System.out.print(each + " ");
        }
    }

    public int[] input(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        // for (int i = nums.length - 2; i >= 0; i--) {
        // stack.push(nums[i]);
        // }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
