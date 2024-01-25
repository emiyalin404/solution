import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPlayersWithZeroorOneLosses {
    public static void main(String[] args) {
        FindPlayersWithZeroorOneLosses solution = new FindPlayersWithZeroorOneLosses();
        int[][] matches = { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 }, { 4, 9 }, { 10, 4 } };
        List<List<Integer>> ans = solution.input(matches);
        System.out.println(ans);
    }

    public List<List<Integer>> input(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
            map.put(matches[i][0], map.getOrDefault(matches[i][0], 0));
        }

        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                result.get(0).add(entry.getKey());
            } else if (entry.getValue() == 1) {
                result.get(1).add(entry.getKey());
            }
        }
        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        return result;
        // List<List<Integer>> result = new ArrayList<>();
        // Map<Integer, Integer> map = new HashMap<>();
        // int n = matches.length;
        // for (int i = 0; i < n; i++) {
        // map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
        // map.put(matches[i][0], map.getOrDefault(matches[i][0], 0));
        // }

        // result.add(new ArrayList<>());
        // result.add(new ArrayList<>());

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // if (entry.getValue() == 0) {
        // result.get(0).add(entry.getKey());
        // } else if (entry.getValue() == 1) {
        // result.get(1).add(entry.getKey());
        // }
        // }
        // Collections.sort(result.get(0));
        // Collections.sort(result.get(1));

        // return result;

    }
}
