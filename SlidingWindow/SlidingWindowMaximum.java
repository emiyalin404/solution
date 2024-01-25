import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] ans = solution.input(nums, k);
        System.out.println(ans);
    }

    public int[] input(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int ind = 0;
        for (int i = 0; i < k; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                ind = i;
            }
        }
        list.add(max);
        int l = 1;
        int j = l + k - 1;
        while (j < nums.length) {
            if (ind >= l && max > nums[j]) {
                list.add(max);
            } else if (ind >= l && max <= nums[j]) {
                ind = j;
                max = nums[j];
                list.add(max);
            } else if (ind < l) {
                int tempMax = Integer.MIN_VALUE;
                for (int i = 0; i <= j; i++) {
                    if (tempMax <= nums[i]) {
                        tempMax = nums[i];
                        ind = i;
                    }
                }
                max = tempMax;
                list.add(max);
            }
            l++;
            j++;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
