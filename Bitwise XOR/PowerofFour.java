public class PowerofFour {
    public static void main(String[] args) {
        PowerofFour solution = new PowerofFour();
        int n = 16;
        boolean ans = solution.input(n);
        System.out.println(ans);
    }

    public boolean input(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }
}
