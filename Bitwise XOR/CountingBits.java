public class CountingBits {
    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        int n = 2;
        int[] ans = solution.input(n);
        System.out.println(ans);
    }

    public int[] input(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) { // 修改循环终止条件为n
            int a = i;
            while (a > 0) {
                ans[i] += a & 1;
                a >>= 1;
            }
        }
        return ans;

        // int[] ans = new int[n + 1];
        // ans[0] = 0;
        // for (int i = 1; i <= n; i++) {
        // ans[i] = ans[i >> 1] + (i & 1);
        // }
        // return ans;
    }
}
