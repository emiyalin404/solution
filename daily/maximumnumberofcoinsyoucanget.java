import java.util.Arrays;

public class maximumnumberofcoinsyoucanget {
    public static void main(String[] args) {
        maximumnumberofcoinsyoucanget solution = new maximumnumberofcoinsyoucanget();
        int[] piles = { 9, 8, 7, 6, 5, 1, 2, 3, 4 };
        int ans = solution.input(piles);
        System.out.println(ans);
    }

    public int input(int[] piles) {
        Arrays.sort(piles);
        int total = 0;
        int n = piles.length / 3;
        for (int i = piles.length - 2; i >= n; i -= 2) {
            total += piles[i];
        }
        return total;
    }
}
