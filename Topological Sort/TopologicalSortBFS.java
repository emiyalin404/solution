import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        TopologicalSortBFS solution = new TopologicalSortBFS();
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int[] result = solution.topologicalSort(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }

    public int[] topologicalSort(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjacen = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacen.computeIfAbsent(prerequisiteCourse, k -> new ArrayList<>()).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index] = course;
            index++;

            if (adjacen.containsKey(course)) {
                for (int neighbor : adjacen.get(course)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        if (index == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
