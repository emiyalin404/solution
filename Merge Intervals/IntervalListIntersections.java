import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
        IntervalListIntersections solut = new IntervalListIntersections();
        int[][] firsiList = { { 0, 2 }, { 4, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        int[][] ans = solut.input(firsiList, secondList);
        System.out.println(ans);
    }

    public int[][] input(int[][] firstList, int[][] secondList) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] current = firstList[i];
            int[] second = secondList[j];
            if (current[0] <= second[0] && current[1] >= second[0]) {
                merged.add(new int[] { second[0], Math.min(current[1], second[1]) });
            } else if (current[0] <= second[1] && current[0] >= second[0]) {
                merged.add(new int[] { current[0], Math.min(current[1], second[1]) });
            }
            if (current[1] <= second[1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] result = new int[merged.size()][2];
        for (int a = 0; a < merged.size(); a++) {
            result[a] = merged.get(a);
        }
        return result;

    }
}
