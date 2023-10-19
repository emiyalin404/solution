import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedList;
import java.util.List;
// import java.util.Queue;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] ans = solution.input(numCourses, prerequisites);
        System.out.println(ans);
    }

    // int p[], pos = 0;
    // HashSet<Integer> visi = new HashSet<Integer>();
    // HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public int[] input(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }
        int[] visited = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited, ans)) {
                return new int[0];
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();

    }

    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited, List<Integer> ans) {
        if (visited[curr] == 1) {
            return true;
        }
        if (visited[curr] == 2) {
            return false;
        }
        visited[curr] = 1;
        for (int next : graph.get(curr)) {
            if (dfs(next, graph, visited, ans)) {
                return true;
            }

        }
        visited[curr] = 2;
        ans.add(curr);

        return false;
    }
    // public int[] input(int numCourses, int[][] prer) {
    // int i, n = prer.length;
    // for (i = 0; i < n; i++) {
    // List<Integer> lis = map.getOrDefault(prer[i][0], new ArrayList<Integer>());
    // lis.add(prer[i][1]);
    // map.put(prer[i][0], lis);
    // }
    // p = new int[numCourses];
    // for (i = 0; i < numCourses; i++) {
    // if (!map.containsKey(i)) {
    // p[pos++] = i;
    // visi.add(i);
    // }
    // }
    // for (i = 0; i < n; i++) {
    // if (!visi.contains(prer[i][0])) {
    // if (!dfs(prer[i][0], new HashSet<Integer>()))
    // return new int[0];
    // }
    // }
    // return p;
    // }

    // boolean dfs(int cour, HashSet<Integer> set) {
    // if (visi.contains(cour))
    // return true;
    // if (!map.containsKey(cour) || map.get(cour).size() == 0) {
    // p[pos++] = cour;
    // visi.add(cour);
    // } else {
    // for (int node : map.get(cour)) {
    // if (set.contains(node))
    // return false;
    // set.add(node);
    // if (!visi.contains(node)) {
    // if (!dfs(node, set))
    // return false;
    // }
    // set.remove(node);
    // }
    // p[pos++] = cour;
    // visi.add(cour);
    // }
    // return true;
    // }
}
