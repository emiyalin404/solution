import java.util.ArrayList;
import java.util.LinkedList;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        boolean ans = solution.input(numCourses, prerequisites);
        System.out.println(ans);
    }

    public boolean input(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            in[prerequisites[i][1]]++;
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int temp = queue.poll();
            for (int w : adj.get(temp)) {
                in[w]--;
                if (in[w] == 0) {
                    queue.add(w);
                }
            }
        }
        if (count == numCourses) {
            return true;
        }
        return false;
    }
    // public boolean input(int numCourses, int[][] prerequisites) {
    // ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // for (int i = 0; i < numCourses; ++i)
    // graph.add(new ArrayList<Integer>());

    // for (int i = 0; i < prerequisites.length; ++i) {
    // int course = prerequisites[i][0];
    // int prerequisite = prerequisites[i][1];
    // graph.get(course).add(prerequisite);
    // }

    // int[] visited = new int[numCourses];
    // for (int i = 0; i < numCourses; ++i)
    // if (dfs(i, graph, visited))
    // return false;

    // return true;
    // }
    // private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[]
    // visited) {
    // if (visited[curr] == 1)
    // return true;
    // if (visited[curr] == 2)
    // return false;
    // visited[curr] = 1;
    // for (int next : graph.get(curr)) {
    // if (dfs(next, graph, visited))
    // return true;

    // }
    // visited[curr] = 2;
    // return false;
    // }
}
