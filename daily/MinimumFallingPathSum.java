public class MinimumFallingPathSum {
    public static void main(String[] args) {
        MinimumFallingPathSum solution = new MinimumFallingPathSum();
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int ans = solution.input(matrix);
        System.out.println(ans);
    }

    public int input(int[][] matrix) {
        int n = matrix.length;
        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                int min = matrix[r + 1][c];
                if (c > 0)
                    min = Math.min(min, matrix[r + 1][c - 1]);
                if (c < n - 1)
                    min = Math.min(min, matrix[r + 1][c + 1]);
                matrix[r][c] += min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, matrix[0][i]);
        }
        return ans;
    }
}
