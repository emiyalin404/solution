public class IntegerReplacement {
    public static void main(String[] args) {
        IntegerReplacement solution = new IntegerReplacement();
        int n = 7;
        int ans = solution.input(n);
        System.out.println(ans);
    }

    public int input(int n) {
       return replace((long)n);

    }

    int replace(long n) {
        int ans = 0;
        if (n <= 1) {
            return 0;
        }
        if (n % 2 == 0) {
            ans = 1 + replace(n / 2);
        } else {
            ans = 1 + Math.min(replace(n + 1), replace(n - 1));
        }
        return ans;
    }
}
