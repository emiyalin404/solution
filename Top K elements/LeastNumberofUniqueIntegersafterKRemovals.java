import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberofUniqueIntegersafterKRemovals {
    public static void main(String[] args) {
        LeastNumberofUniqueIntegersafterKRemovals solution = new LeastNumberofUniqueIntegersafterKRemovals();
        int[] arr = { 4, 3, 1, 1, 3, 3, 2 };
        int k = 3;
        int ans = solution.input(arr, k);
        System.out.println(ans);
    }

    public int input(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int w : map.keySet()) {
            pq.offer(new int[] { w, map.get(w) });
        }
        for (int i = 0; i < k; i++) {
            int a[] = pq.poll();
            if (a[1] > 1) {
                a[1]--;
                pq.offer(a);
            }
        }
        return pq.size();
    }
}
