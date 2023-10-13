import java.util.HashSet;
import java.util.PriorityQueue;
// import java.util.Set;

public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII solution = new UglyNumberII();
        int n = 1407;
        int ans = solution.input(n);
        System.out.println(ans);
    }

    int[] factors = { 2, 3, 5 };

    public int input(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        pq.add(1L);
        seen.add(1L);
        long val = 1L;
        for (int i = 0; i < n; ++i) {
            val = pq.poll();
            if (!seen.contains(val * 2)) {
                pq.add(val * 2);
                seen.add(val * 2);
            }
            if (!seen.contains(val * 3)) {
                pq.add(val * 3);
                seen.add(val * 3);
            }
            if (!seen.contains(val * 5)) {
                pq.add(val * 5);
                seen.add(val * 5);
            }
        }
        return (int) val;
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Set<Integer> seen = new HashSet<>();
        // pq.offer(1);
        // pq.add(1);
        // for (int i = 0; i < n; i++) {
        // int core = pq.poll();
        // for (int f : factors) {
        // if (core <= (Integer.MAX_VALUE / f) && seen.add(core * f))
        // pq.offer(core * f);
        // }
        // }
        // return pq.poll();
    }
}
