
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    private int V; // 图中节点的数量
    private List<Integer> adj[]; // 邻接表表示图

    public TopologicalSort(int v) {
        V = v;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // 添加边，表示节点之间的关系
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (Integer neighbor : adj[v]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        // 当节点的所有邻居都已经访问完毕，将节点压入栈中
        stack.push(v);
    }

    // 执行拓扑排序
    public List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        // 对每个尚未访问的节点执行深度优先搜索
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // 从栈中弹出节点，即可获得拓扑排序结果
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        List<Integer> topologicalOrder = g.topologicalSort();
        System.out.println("Topological Sorting: " + topologicalOrder);
    }
}
