public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 2;
        int ans = solution.input(s, k);
        System.out.println(ans);
    }

    public int input(String s, int k) {
        int[] charCount = new int[2];
        int maxCount = 0;
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount[currentChar - 'A']++;
            maxCount = Math.max(maxCount, charCount[currentChar - 'A']);
            if (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
        // int[] charCount = new int[26]; // 用于记录每个字符出现的次数
        // int maxCount = 0; // 记录窗口内出现最多字符的次数
        // int left = 0; // 左边界
        // int maxLength = 0; // 最长子字符串的长度

        // for (int right = 0; right < s.length(); right++) {
        // char currentChar = s.charAt(right);
        // charCount[currentChar - 'A']++; // 更新字符计数

        // // 更新窗口内出现最多字符的次数
        // maxCount = Math.max(maxCount, charCount[currentChar - 'A']);

        // // 如果窗口内字符数量加上允许替换的次数小于窗口大小，则窗口可以扩展
        // if (right - left + 1 - maxCount > k) {
        // char leftChar = s.charAt(left);
        // charCount[leftChar - 'A']--; // 缩小窗口
        // left++;
        // }

        // // 更新最大子字符串长度
        // maxLength = Math.max(maxLength, right - left + 1);
        // }

        // return maxLength;
    }
}
