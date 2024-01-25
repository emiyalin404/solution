import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberofOccurrences {
    public static void main(String[] args) {
        UniqueNumberofOccurrences solution = new UniqueNumberofOccurrences();
        int[] arr = { 1, 2, 2, 1, 1, 3 };
        boolean ans = solution.input(arr);
        System.out.println(ans);
    }

    public boolean input(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if (!hashSet.add(mapEntry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
