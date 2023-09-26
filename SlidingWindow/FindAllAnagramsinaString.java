import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.TreeMap;

public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        FindAllAnagramsinaString solution = new FindAllAnagramsinaString();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = solution.input(s, p);
        System.out.println(ans);
    }

    public List<Integer> input(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (sMap.equals(pMap)) {
            ans.add(0);
        }
        int l = 0, r = p.length();
        while (r < s.length()) {
            char acquire = s.charAt(r++);
            sMap.put(acquire, sMap.getOrDefault(acquire, 0) + 1);
            char discard = s.charAt(l++);
            sMap.put(discard, sMap.get(discard) - 1);
            if (sMap.get(discard) == 0) {
                sMap.remove(discard);
            }
            if (sMap.equals(pMap)) {
                ans.add(l);
            }
        }
        return ans;
        // Map<Character, Integer> map2 = new TreeMap<>();
        // Map<Character, Integer> temp = new TreeMap<>();
        // List<Integer> ans = new ArrayList<>();

        // for (int i = 0; i < p.length(); i++) {
        // map2.put(p.charAt(i), map2.getOrDefault(p.charAt(i), 0) + 1);
        // }
        // int i = 0;
        // int j = 0;

        // while (j < s.length()) {
        // temp.put(s.charAt(j), temp.getOrDefault(s.charAt(j), 0) + 1);
        // if (j - i + 1 < p.length()) {
        // j++;
        // }
        // else if (j - i + 1 == p.length()) {
        // // System.out.println(temp);
        // if (temp.equals(map2)) {
        // ans.add(i);
        // }
        // temp.put(s.charAt(i), temp.getOrDefault(s.charAt(i), 0) - 1);
        // if (temp.get(s.charAt(i)) == 0) {
        // temp.remove(s.charAt(i));
        // }
        // i++;
        // j++;
        // }
        // }
        // return ans;
    }
}
