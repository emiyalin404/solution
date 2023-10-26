import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        FindEventualSafeStates solution = new FindEventualSafeStates();
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        List<Integer> ans = solution.input(graph);
        System.out.println(ans);
    }

    public List<Integer> input(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        List<List<Integer>> connected = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connected.add(new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            if (outdegree[i] == 0) {
                ans.add(i);
                q.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int e : graph[i]) {
                connected.get(e).add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int e : connected.get(node)) {
                outdegree[e]--;
                if (outdegree[e] == 0) {
                    ans.add(e);
                    q.add(e);
                }
            }
        }
        Collections.sort(ans);
        return ans;
        // int n = graph.length;
        // int[] outdegree = new int[n];
        // List<List<Integer>> connected = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        // connected.add(new ArrayList<>());
        // }
        // List<Integer> ans = new ArrayList<>();
        // Queue<Integer> q = new LinkedList<>();
        // for (int i = 0; i < n; i++) {
        // outdegree[i] = graph[i].length;
        // if (outdegree[i] == 0) {
        // ans.add(i);
        // q.add(i);
        // }
        // }
        // for (int i = 0; i < n; i++) {
        // for (int e : graph[i]) {
        // connected.get(e).add(i);
        // }
        // }
        // while (!q.isEmpty()) {
        // int node = q.poll();
        // for (int e : connected.get(node)) {
        // outdegree[e]--;
        // if (outdegree[e] == 0) {
        // ans.add(e);
        // q.add(e);
        // }
        // }
        // }
        // Collections.sort(ans);
        // return ans;
    }
}
