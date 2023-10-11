import java.util.Arrays;

public class MeetingRoomsII {
    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int ans = solution.input(intervals);
        System.out.println(ans);
    }

    public int input(int[][] intervals) {
        int n = intervals.length;
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int meetroom = 0;
        int endindex = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] < endTime[endindex]) {
                meetroom++;
            } else {
                endindex++;
            }
        }
        return meetroom;
        // int n = intervals.length;
        // int[] startTime = new int[n];
        // int[] endTime = new int[n];
        // for (int i = 0; i < n; i++) {
        // startTime[i] = intervals[i][0];
        // endTime[i] = intervals[i][1];
        // }
        // Arrays.sort(startTime);
        // Arrays.sort(endTime);
        // int meetingRooms = 0;
        // int endIndex = 0;
        // for (int i = 0; i < n; i++) {
        // if (startTime[i] < endTime[endIndex]) {
        // meetingRooms++;
        // } else {
        // endIndex++;
        // }
        // }
        // return meetingRooms;

        // ------------------------------------------
        // int count = 0;
        // if (intervals == null || intervals.length == 0) {
        // return count;
        // }
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // int i = 0;
        // while (i < intervals.length) {
        // int[] current = intervals[i];
        // for (int j = i; j < intervals.length - 1; j++) {
        // int[] second = intervals[j + 1];
        // if (current[1] >= second[0]) {
        // count++;
        // }
        // }
        // i++;
        // }
        // return count;
    }
}
