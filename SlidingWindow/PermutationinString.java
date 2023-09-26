import java.util.HashMap;

public class PermutationinString {
    public static void main(String[] args) {
        PermutationinString solution = new PermutationinString();
        String s1 = "ab";
        String s2 = "eiidbaooo";
        boolean ans = solution.input(s1, s2);
        System.out.println(ans);
    }

    public boolean input(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            map1.put(c1, map1.getOrDefault(c1, 0) + 1);
        }
        ;
        for (int right = 0; right < s2.length(); right++) {
            char c2 = s2.charAt(right);
            map2.put(c2, map2.getOrDefault(c2, 0) + 1);
            if (right - left + 1 == s1.length()) {
                if (map1.equals(map2)) {
                    return true;
                }
                char c = s2.charAt(left);
                map2.put(c, map2.get(c) - 1);
                if (map2.get(c) == 0) {
                    map2.remove(c);
                }
                left++;
            }
        }
        return false;
        // if (s1.length() > s2.length()) {
        // return false; // s2 不可能包含 s1 的排列
        // }
        // HashMap<Character, Integer> char1 = new HashMap<>();
        // HashMap<Character, Integer> char2 = new HashMap<>();
        // // 初始化 char1，记录 s1 中每个字符的出现次数
        // for (int i = 0; i < s1.length(); i++) {
        // char c = s1.charAt(i);
        // char1.put(c, char1.getOrDefault(c, 0) + 1);
        // }
        // int left = 0;
        // for (int right = 0; right < s2.length(); right++) {
        // char c2 = s2.charAt(right);
        // // 维护 char2，记录窗口中每个字符的出现次数
        // char2.put(c2, char2.getOrDefault(c2, 0) + 1);
        // // 当窗口大小达到 s1.length() 时，检查 char1 和 char2 是否相等
        // if (right - left + 1 == s1.length()) {
        // if (char1.equals(char2)) {
        // return true; // 找到 s1 的排列
        // }
        // // 移动窗口左边界
        // char c1 = s2.charAt(left);
        // char2.put(c1, char2.get(c1) - 1);
        // if (char2.get(c1) == 0) {
        // char2.remove(c1);
        // }
        // left++;
        // }
        // }

        // return false;
    }
}
