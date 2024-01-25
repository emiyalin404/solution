import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        int ans = solution.input(s);
        System.out.println(ans);
    }

    public int input(String s) {
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char leftmap = s.charAt(left);
                map.put(leftmap, map.get(leftmap) - 1);
                if (map.get(leftmap) == 0) {
                    map.remove(leftmap);
                }

                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;

        // int left = 0;
        // int maxLength = 0;
        // HashMap<Character, Integer> charmap = new HashMap<>();
        // for (int right = 0; right < s.length(); right++) {
        // char c = s.charAt(right);
        // charmap.put(c, charmap.getOrDefault(c, 0) + 1);
        // while (charmap.get(c) > 1) {
        // char leftChar = s.charAt(left);
        // charmap.put(leftChar, charmap.get(leftChar) - 1);
        // if (charmap.get(leftChar) == 0) {
        // charmap.remove(leftChar);
        // }
        // left++;
        // }
        // maxLength = Math.max(maxLength, right - left + 1);
        // }
        // return maxLength;
    }
}
