import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        GrayCode solution = new GrayCode();
        int n = 2;
        List<Integer> ans = solution.input(n);
        System.out.println(ans);
    }

    public List<Integer> input(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            ans.add(i ^ i >> 1);
        }
        return ans;
    }
}
