import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {
    public static void main(String[] args) {
        NumberofIslands solution = new NumberofIslands();
        char[][] grid = { { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        int ans = solution.input(grid);
        System.out.println(ans);
    }

    public int input(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] direction = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] { i, j });

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int[] dir : direction) {
                            int newRow = current[0] + dir[0];
                            int newCol = current[1] + dir[1];

                            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1') {
                                grid[newRow][newCol] = '0';
                                queue.offer(new int[] { newRow, newCol });
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    // public static void main(String[] args) {
    // char[][] grid = {
    // { '1', '1', '0', '1', '0' },
    // { '1', '1', '0', '1', '0' },
    // { '1', '1', '0', '0', '0' },
    // { '0', '0', '0', '0', '0' }
    // };
    // input(grid);
    // }

    // public static void input(char[][] grid) {
    // int m = grid.length;
    // if (m == 0) {
    // return;
    // }
    // int n = grid[0].length;
    // int count = 0;
    // for (int i = 0; i < m; i++) {
    // for (int j = 0; j < n; j++) {
    // if (grid[i][j] == '1') {
    // count++;
    // dfs(grid, i, j);
    // }
    // }
    // }
    // System.out.println(count);
    // // return count;
    // }

    // public static void dfs(char[][] grid, int i, int j) {
    // int m = grid.length;
    // int n = grid[0].length;

    // if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
    // return;
    // }
    // grid[i][j] = '0';
    // dfs(grid, i - 1, j);
    // dfs(grid, i + 1, j);
    // dfs(grid, i, j - 1);
    // dfs(grid, i, j + 1);
    // }
}
