import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        SortCharactersByFrequency solution = new SortCharactersByFrequency();
        String s = "tree";
        String ans = solution.input(s);
        System.out.println(ans);
    }

    public String input(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character val : s.toCharArray()) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder ans = new StringBuilder();
        for (char character : list) {
            int frequency = map.get(character);
            for (int i = 0; i < frequency; i++) {
                ans.append(character);
            }
        }
        return ans.toString();
        // char ans;
        // for (int i = 0; i < s.length(); i++) {
        // ans.add(list.get(i));
        // }

    }
}
