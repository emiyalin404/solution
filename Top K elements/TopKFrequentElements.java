import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = { 1, 1, 1, 2, 2, 3, 4, 4 };
        int k = 2;
        int[] ans = solution.input(nums, k);
        System.out.println(ans);
    }

    public int[] input(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组，将元素及其重复次数添加到Map中
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> valueList = new ArrayList<>(map.keySet());
        valueList.sort((a, b) -> map.get(b) - map.get(a));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = valueList.get(i);
        }

        return result;
    }
}
