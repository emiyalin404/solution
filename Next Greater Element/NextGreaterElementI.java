import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public static void main(String[] args) {
        NextGreaterElementI solution = new NextGreaterElementI();
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] ans = solution.input(nums1, nums2);
        System.out.println(ans);
    }

    public int[] input(int[] arr, int[] nums) {
        Map<Integer, Integer> next = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[arr.length];
        for (int x : nums) {
            while (!st.isEmpty() && x > st.peek()) {
                next.put(st.pop(), x);
            }
            st.push(x);
        }
        for (int i = 0; i < arr.length; i++) {
            if (next.containsKey(arr[i])) {
                res[i] = next.get(arr[i]);
            } else {
                res[i] = -1;
            }
        }
        return res;
        // Map<Integer, Integer> next = new HashMap<>();
        // Deque<Integer> st = new ArrayDeque<>();
        // int[] res = new int[arr.length];
        // for (int x : nums) {
        // while (!st.isEmpty() && x > st.peek()) {
        // next.put(st.pop(), x);
        // }
        // st.push(x);
        // }
        // for (int i = 0; i < arr.length; i++) {
        // if (next.containsKey(arr[i])) {
        // res[i] = next.get(arr[i]);
        // } else {
        // res[i] = -1;
        // }
        // }
        // return res;
    }
}
