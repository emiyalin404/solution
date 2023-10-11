import java.util.Arrays;

public class MeetingRooms {
    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        boolean ans = solution.input(intervals);
        System.out.println(ans);
    }

    public boolean input(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        while (i < intervals.length - 1) {
            int[] current = intervals[i];
            int[] second = intervals[i + 1];
            if (current[1] > second[1]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
