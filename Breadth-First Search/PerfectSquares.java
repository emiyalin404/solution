import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();
        int nums = 12;
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] squar = new int[(int) Math.sqrt(n) + 1];
        for (int i = 1; i <= Math.sqrt(n); i++) {
            squar[i] = i * i;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int squa : squar) {
                    int next = current + squa;
                    if (next == n) {
                        return step;
                    } else if (next < n) {
                        queue.offer(next);
                    }
                }
            }
        }
        return 0;
    }
}
