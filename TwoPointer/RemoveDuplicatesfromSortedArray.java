// import java.util.ArrayList;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray solution = new RemoveDuplicatesfromSortedArray();
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int ans = solution.input(nums);
        System.out.println(ans);
        System.out.print("Array: [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
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
