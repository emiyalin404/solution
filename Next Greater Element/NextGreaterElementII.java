import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        NextGreaterElementII solution = new NextGreaterElementII();
        int[] nums = { 1, 2, 1 };
        int[] ans = solution.input(nums);
        System.out.println(ans);
    }

    public int[] input(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            stack.push(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println(stack.peek());
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return res;
        // Stack<Integer> stack = new Stack<>();
        // int[] ans = new int[nums.length];
        // for (int i = nums.length - 2; i >= 0; i--) {
        // stack.push(nums[i]);
        // }
        // for (int i = nums.length - 1; i >= 0; i--) {
        // while (!stack.isEmpty() && nums[i] >= stack.peek()) {
        // stack.pop();
        // }
        // if (stack.isEmpty())
        // ans[i] = -1;
        // else
        // ans[i] = stack.peek();

        // stack.push(nums[i]);
        // }
        // return ans;
    }
}
