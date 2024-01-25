public class PowerofTwo {
    public static void main(String[] args) {
        PowerofTwo solution = new PowerofTwo();
        int n = -2;
        boolean ans = solution.input(n);
        System.out.println(ans);
    }

    public boolean input(int n) {
        if (n == 1) {
            return true;
        }
        while ((n % 2) == 0) {
            n = n / 2;
            if (n == 1) {
                return true;
            } else if (n == 0) {
                return false;
            }
        }
        return false;
    }
}
