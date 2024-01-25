public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        BitwiseANDofNumbersRange solution = new BitwiseANDofNumbersRange();
        int left = 5;
        int right = 7;
        int ans = solution.input(left, right);
        System.out.println(ans);
    }

    public int input(int left, int right) {
        int n = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            n++;
        }
        return left << n;
    }

}
