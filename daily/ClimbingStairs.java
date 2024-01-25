public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int n = 45;
        int ans = solution.input(n);
        System.out.println(ans);
    }

    public int input(int n) {
        if (n <= 2)
            return n;
        int[] res = new int[n];
        res[1 - 1] = 1;
        res[2 - 1] = 2;
        for (int i = 3; i <= n; i++) {
            res[i - 1] = res[i - 1 - 1] + res[i - 2 - 1];
        }
        return res[n - 1];
        // if (n == 1)
        // return 1;
        // else if (n == 2)
        // return 2;
        // return (input(n - 1) + input(n - 2));
    }
}
