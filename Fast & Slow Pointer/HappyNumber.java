// import java.util.LinkedList;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        int n = 19;
        boolean ans = solution.input(n);
        System.out.println(ans);
    }

    public boolean input(int n) {
        int slow = n;
        int fast = n;
        // while loop is not used here because initially slow and
        // fast pointer will be equal only, so the loop won't run.
        do {
            // slow moving one step ahead and fast moving two steps ahead

            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

        // if a cycle exists, then the number is not a happy number
        // and slow will have a value other than 1

        return slow == 1;
    }

    public int square(int n) {
        int ans = 0;

        while (n > 0) {
            int remainder = n % 10;
            ans += remainder * remainder;
            n /= 10;
        }

        return ans;
    }
}
