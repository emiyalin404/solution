import java.util.HashMap;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringwithAtMostKDistinctCharacters solution = new LongestSubstringwithAtMostKDistinctCharacters();
        String s = "eceba";
        int k = 2;
        int ans = solution.input(s, k);
        System.out.println(ans);
    }

    public int input(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> charmap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charmap.put(c, charmap.getOrDefault(c, 0) + 1);
            while (charmap.size() > k) {
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
        // if (s == null || s.length() == 0 || k == 0) {
        // return 0;
        // }
        // int left = 0;
        // int maxLength = 0;
        // HashMap<Character, Integer> charCount = new HashMap<>();
        // for (int right = 0; right < s.length(); right++) {
        // char c = s.charAt(right);
        // charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        // while (charCount.size() > k) {
        // char leftChar = s.charAt(left);
        // charCount.put(leftChar, charCount.get(leftChar) - 1);
        // if (charCount.get(leftChar) == 0) {
        // charCount.remove(leftChar);
        // }
        // left++;
        // }
        // maxLength = Math.max(maxLength, right - left + 1);
        // }
        // return maxLength;
    }

}
