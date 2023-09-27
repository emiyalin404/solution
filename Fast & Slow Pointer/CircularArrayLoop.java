public class CircularArrayLoop {
    public static void main(String[] args) {
        CircularArrayLoop solution = new CircularArrayLoop();
        int[] nums = { 2, -1, 1, 2, 2 };
        boolean ans = solution.input(nums);
        System.out.println(ans);
    }

    public boolean input(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;

            do {
                slow = getNextIndex(nums, slow, isForward);
                fast = getNextIndex(nums, fast, isForward);
                if (fast != -1) {
                    fast = getNextIndex(nums, fast, isForward);
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int getNextIndex(int[] nums, int curr, boolean isForward) {
        int nextIndex = (curr + nums[curr]) % nums.length;
        if (nextIndex < 0) {
            nextIndex += nums.length;
        }
        if (nextIndex == curr || nums[nextIndex] * (isForward ? 1 : -1) <= 0) {
            return -1;
        }
        return nextIndex;
    }
}
