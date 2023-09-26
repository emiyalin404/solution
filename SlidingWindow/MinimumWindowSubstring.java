import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = solution.input(s, t);
        System.out.println(ans);
    }

    public String input(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int need = 0;
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            need++;
        }
        Map<Character, Integer> smap = new HashMap<>();
        int have = 0, i = 0, j = 0;
        String ans = "";
        int len = Integer.MAX_VALUE;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                smap.put(s.charAt(j), smap.getOrDefault(s.charAt(j), 0) + 1);
                if (smap.get(s.charAt(j)) <= map.get(s.charAt(j))) {
                    have++;
                }
            }
            while (need == have) {
                if (j - i + 1 < len) {
                    ans = s.substring(i, j + 1);
                    len = j - i + 1;
                }
                if (smap.containsKey(s.charAt(i))) {
                    if (smap.get(s.charAt(i)) <= map.get(s.charAt(i))) {
                        have--;
                    }
                    smap.put(s.charAt(i), smap.get(s.charAt(i)) - 1);
                }
                i++;
            }
            j++;
        }
        return ans;
        // Map<Character, Integer> map = new HashMap<>();
        // int need = 0;
        // for (int i = 0; i < t.length(); i++) {
        // map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        // need++;
        // }
        // Map<Character, Integer> smap = new HashMap<>();
        // int have = 0;
        // String ans = "";
        // int len = Integer.MAX_VALUE;
        // int i = 0;
        // int j = 0;
        // while (j < s.length()) {
        // if (map.containsKey(s.charAt(j))) {
        // smap.put(s.charAt(j), smap.getOrDefault(s.charAt(j), 0) + 1);
        // if (smap.get(s.charAt(j)) <= map.get(s.charAt(j))) {
        // have++;
        // }
        // }
        // while (need == have) {
        // if (j - i + 1 < len) {
        // ans = s.substring(i, j + 1);
        // len = j - i + 1;
        // }
        // if (smap.containsKey(s.charAt(i))) {
        // if (smap.get(s.charAt(i)) <= map.get(s.charAt(i))) {
        // have--;
        // }
        // smap.put(s.charAt(i), smap.get(s.charAt(i)) - 1);
        // }
        // i++;
        // }
        // j++;
        // }
        // return ans;
    }
}
