import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildanArrayWithStackOperations {
    public static void main(String[] args) {
        BuildanArrayWithStackOperations solution = new BuildanArrayWithStackOperations();
        int[] target = { 1, 3 };
        int n = 3;
        List<String> ans = solution.input(target, n);
        System.out.println(ans);
    }

    public List<String> input(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        int currentindex = 0;
        for (int i = 1; i <= n; i++) {
            if (currentindex >= target.length) {
                break;
            }
            stack.push(i);
            result.add("Push");
            if (stack.peek() == target[currentindex]) {
                currentindex++;
            } else {
                stack.pop();
                result.add("Pop");
            }
        }
        return result;
    }
}
