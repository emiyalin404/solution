import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleIV {
    public static void main(String[] args) {
        CourseScheduleIV solution = new CourseScheduleIV();
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        int[][] queries = { { 0, 1 }, { 1, 0 } };
        List<Boolean> ans = solution.input(numCourses, prerequisites, queries);
        System.out.println(ans);

    }

    public List<Boolean> input(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int independent = prerequisites[i][0];
            int dependent = prerequisites[i][1];
            inDegree[dependent]++;
            graph.putIfAbsent(independent, new HashSet<>());
            graph.get(independent).add(dependent);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        boolean[][] dependency = new boolean[101][101];
        for (int i = 0; i < 101; i++) {
            dependency[i][i] = true;
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (graph.get(node) == null) {
                continue;
            }
            for (Integer child : graph.get(node)) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
                for (int i = 0; i < 101; i++) {
                    dependency[child][i] |= dependency[node][i];
                }
            }
        }
        List<Boolean> queriesAns = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int independent = queries[i][0];
            int dependent = queries[i][1];
            queriesAns.add(dependency[dependent][independent]);
        }
        return queriesAns;
    }
}
