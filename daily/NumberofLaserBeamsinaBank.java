public class NumberofLaserBeamsinaBank {
    public static void main(String[] args) {
        NumberofLaserBeamsinaBank solution = new NumberofLaserBeamsinaBank();
        String[] bank = { "011001", "000000", "010100", "001000" };
        int ans = solution.input(bank);
        System.out.println(ans);
    }

    public int input(String[] bank) {
        int n = bank.length;
        char temp;
        int ans = 0;
        int next = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                temp = bank[i].charAt(j);
                if (temp == '1') {
                    count++;
                }
            }
            if (count > 0) {
                ans += count * next;
                next = count;
            }
        }
        return ans;

    }
}