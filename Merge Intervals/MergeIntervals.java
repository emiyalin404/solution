import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 9, 18 } };
        int[][] ans = solution.input(intervals);
        System.out.println(ans);
    }

    public int[][] input(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }

        }
        merged.add(current);

        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
        // if (intervals == null || intervals.length == 0) {
        // return new int[0][];
        // }
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // List<int[]> merged = new ArrayList<>();
        // int[] current = intervals[0];
        // for (int i = 1; i < intervals.length; i++) {
        // int[] next = intervals[i];
        // if (current[1] >= next[0]) {
        // current[1] = Math.max(current[1], next[1]);
        // } else {
        // merged.add(current);
        // current = next;
        // }
        // }
        // merged.add(current);

        // int[][] result = new int[merged.size()][2];
        // for (int i = 0; i < merged.size(); i++) {
        // result[i] = merged.get(i);
        // }
        // return result;
    }
}
