
public class LoudandRich {
    public static void main(String[] args) {
        LoudandRich solution = new LoudandRich();
        int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
        int[] quiet = { 3, 2, 5, 4, 6, 1, 7, 0 };
        int[] ans = solution.input(richer, quiet);
        System.out.println(ans);
    }

    public int[] input(int[][] richer, int[] quiet) {
        int[] quietest = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            quietest[i] = searchForQuietest(richer, quiet, i, quietest);
        }
        return quietest;
    }

    public int searchForQuietest(int[][] richer, int[] quiet, int person, int[] quietest) {
        int leastQuiet = person;
        for (int i = 0; i < richer.length; i++) {
            if (richer[i][1] == person) {
                int leastQuietPerson;
                if (quietest[richer[i][0]] != 0)
                    leastQuietPerson = quietest[richer[i][0]];
                else
                    leastQuietPerson = searchForQuietest(richer, quiet, richer[i][0], quietest);
                leastQuiet = Math.min(quiet[leastQuietPerson], quiet[leastQuiet]) == quiet[leastQuiet] ? leastQuiet
                        : leastQuietPerson;
            }
        }
        return leastQuiet;
    }
}
