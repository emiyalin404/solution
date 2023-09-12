// import java.util.ArrayList;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray solution = new RemoveDuplicatesfromSortedArray();
        int[] nums = { 1, 1, 2 };
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int[] nums) {
        // ArrayList<Integer> list = new ArrayList<>();
        // for (int i = 0; i < nums.length; i++) {
        // if (!list.contains(nums[i])) {
        // list.add(nums[i]);
        // }
        // }
        // for (int i = 0; i < list.size(); i++) {
        // nums[i] = list.get(i);
        // }
        // return list.size();
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
