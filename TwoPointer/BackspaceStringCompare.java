public class BackspaceStringCompare {
    public static void main(String[] args) {
        BackspaceStringCompare solution = new BackspaceStringCompare();
        String s = "bb#c", t = "ab#c";
        boolean ans = solution.input(s, t);
        System.out.println(ans);
    }

    public boolean input(String s, String t) {
        int slen = s.length() - 1;
        int tlen = t.length() - 1;
        while (slen >= 0 || tlen >= 0) {
            int sSkip = 0;
            while (slen >= 0) {
                if (s.charAt(slen) == '#') {
                    sSkip++;
                    slen--;
                } else if (sSkip > 0) {
                    sSkip--;
                    slen--;
                } else {
                    break;
                }

                System.out.println(s.charAt(slen));
            }
            int tSkip = 0;
            while (tlen >= 0) {
                if (t.charAt(tlen) == '#') {
                    tSkip++;
                    tlen--;
                } else if (tSkip > 0) {
                    tSkip--;
                    tlen--;
                } else {
                    break;
                }

                System.out.println(t.charAt(tlen));
            }
            if (slen >= 0 && tlen >= 0 && s.charAt(slen) == t.charAt(tlen)) {
                slen--;
                tlen--;
            } else {
                return slen == -1 && tlen == -1;
            }
        }
        return true;
    }
}
