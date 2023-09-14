import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters solution = new LongestSubstringwithAtMostTwoDistinctCharacters();
        String s = "ccaabbb";
        int ans = solution.input(s);
        System.out.println(ans);
    }

    public int input(String s) {
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> charmap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charmap.put(c, charmap.getOrDefault(c, 0) + 1);
            while (charmap.size() > 2) {
                char leftChar = s.charAt(left);
                charmap.put(leftChar, charmap.get(leftChar) - 1);
                if (charmap.get(leftChar) == 0) {
                    charmap.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
