import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    public static void main(String[] args) {
        KClosestPointstoOrigin solution = new KClosestPointstoOrigin();
        int[][] point = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        int[][] ans = solution.input(point, k);
        System.out.println(ans);
    }

    public int[][] input(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
