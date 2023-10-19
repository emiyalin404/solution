
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
    public static void main(String[] args) {
        KthSmallestElementinaSortedMatrix solution = new KthSmallestElementinaSortedMatrix();
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;
        int ans = solution.input(matrix, k);
        System.out.println(ans);
    }

    public int input(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();

        // =========================================================================================================
        // int n = matrix.length;
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
        // matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);

        // // Initialize the min heap with the first element from each row.
        // for (int i = 0; i < n; i++) {
        // minHeap.offer(new int[] { i, 0 });
        // }

        // // Extract the k-1 smallest elements from the min heap.
        // for (int i = 0; i < k - 1; i++) {
        // int[] current = minHeap.poll();
        // int row = current[0];
        // int col = current[1];

        // if (col + 1 < n) {
        // minHeap.offer(new int[] { row, col + 1 });
        // }
        // }

        // // The top of the heap contains the kth smallest element.
        // int[] kthSmallest = minHeap.peek();
        // return matrix[kthSmallest[0]][kthSmallest[1]];
    }
}
