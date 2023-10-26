import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class AllAncestorsofaNodeinaDirectedAcyclicGraph {
    public static void main(String[] args) {
        AllAncestorsofaNodeinaDirectedAcyclicGraph solution = new AllAncestorsofaNodeinaDirectedAcyclicGraph();
        int n = 8;
        int[][] edgeList = { { 0, 3 }, { 0, 4 }, { 1, 3 }, { 2, 4 }, { 2, 7 }, { 3, 5 }, { 3, 6 }, { 3, 7 }, { 3, 8 } };
        List<List<Integer>> ans = solution.input(n, edgeList);
        System.out.println(ans);
    }

    public List<List<Integer>> input(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        List<TreeSet<Integer>> ancestorList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ancestorList.add(new TreeSet<>());
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int i = 0; i < edges.length - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            indegree[v]++;
            adj.get(u).add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int node : adj.get(curr)) {
                ancestorList.get(node).addAll(new TreeSet<>(ancestorList.get(curr)));
                ancestorList.get(node).add(curr);

                indegree[node]--;
                if (indegree[node] == 0) {
                    q.add(node);
                }
            }
        }

        for (TreeSet<Integer> set : ancestorList) {
            ans.add(new ArrayList<Integer>(set));
        }

        return ans;
    }
}
