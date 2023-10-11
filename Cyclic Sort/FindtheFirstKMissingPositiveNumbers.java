public class FindtheFirstKMissingPositiveNumbers {
    public static void main(String[] args) {
        FindtheFirstKMissingPositiveNumbers solution = new FindtheFirstKMissingPositiveNumbers();
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;
        int ans = solution.input(arr, k);
        System.out.println(ans);
    }

    public int input(int[] arr, int k) {
        int n = 0;
        int expected = 1;
        while (k > 0) {
            if (n < arr.length && arr[n] == expected) {
                n++;
            } else {
                k--;
            }
            expected++;
        }
        return expected - 1;
        // for (int a : arr) {
        // if (a <= k)
        // k++;
        // else
        // break;
        // }
        // return k;
    }
}
