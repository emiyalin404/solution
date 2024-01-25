import java.util.HashMap;
import java.util.Map;

public class DetermineifStringHalvesAreAlike {
    public static void main(String[] args) {
        DetermineifStringHalvesAreAlike solution = new DetermineifStringHalvesAreAlike();
        String s = "book";
        boolean ans = solution.input(s);
        System.out.println(ans);
    }

    public boolean input(String s) {
        int len = s.length(), count = 0;
        Map<Character, Integer> map = new HashMap<>();
        String a = s.substring(0, len / 2);
        String b = s.substring(len / 2);
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        map.put('A', 0);
        map.put('E', 0);
        map.put('I', 0);
        map.put('O', 0);
        map.put('U', 0);

        for (int i = 0; i < len / 2; i++) {
            char z = a.charAt(i);
            if (map.containsKey(z)) {
                count++;
            }
        }
        for (int i = 0; i < len / 2; i++) {
            char z = b.charAt(i);
            if (map.containsKey(z)) {
                count--;
            }
        }
        return count == 0;
    }
}
