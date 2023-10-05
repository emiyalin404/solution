import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        int[][] grid = {
                { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
                { Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 },
                { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE }
        };
        solution.wallsAndGates(grid);

        // 打印结果
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // 将所有门的位置加入队列作为起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && rooms[newRow][newCol] == Integer.MAX_VALUE) {
                    // 更新距离，并将相邻房间加入队列
                    rooms[newRow][newCol] = rooms[row][col] + 1;
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }
    }

    // public void wallsAndGates(int[][] rooms) {
    // int m = rooms.length;
    // if (m == 0) {
    // return;
    // }
    // int n = rooms[0].length;

    // for (int i = 0; i < m; i++) {
    // for (int j = 0; j < n; j++) {
    // if (rooms[i][j] == 0) {
    // dfs(rooms, i, j, 0);
    // }
    // }
    // }
    // }

    // private void dfs(int[][] rooms, int i, int j, int distance) {
    // int m = rooms.length;
    // int n = rooms[0].length;

    // if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] < distance) {
    // return;
    // }

    // rooms[i][j] = distance;

    // // 向四个方向执行 DFS
    // dfs(rooms, i - 1, j, distance + 1);
    // dfs(rooms, i + 1, j, distance + 1);
    // dfs(rooms, i, j - 1, distance + 1);
    // dfs(rooms, i, j + 1, distance + 1);
    // }
}