import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindAllPossibleRecipesfromGivenSupplies {
    public static void main(String[] args) {
        FindAllPossibleRecipesfromGivenSupplies solution = new FindAllPossibleRecipesfromGivenSupplies();
        String[] recipes = { "bread", "sandwich" };
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        ingredients.add(Arrays.asList("bread", "meat"));
        String[] supplies = { "yeast", "flour", "corn", "meat" };
        List<String> ans = solution.input(recipes, ingredients, supplies);
        System.out.println(ans);
    }

    public List<String> input(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> sup = new HashSet<>();
        HashMap<String, Integer> index = new HashMap<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : supplies) {
            sup.add(s);
        }
        for (int i = 0; i < recipes.length; i++) {
            index.put(recipes[i], i);
        }

        int[] indegree = new int[recipes.length];
        for (int i = 0; i < recipes.length; i++) {
            for (String need : ingredients.get(i)) {
                if (sup.contains(need)) {
                    continue;
                }
                map.putIfAbsent(need, new ArrayList<String>());
                map.get(need).add(recipes[i]);
                indegree[i]++;
            }
        }
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<String> cooked = new ArrayList<>();
        while (!q.isEmpty()) {
            int i = q.poll();
            cooked.add(recipes[i]);

            if (!map.containsKey(recipes[i])) {
                continue;
            }

            for (String recipe : map.get(recipes[i])) {
                if (--indegree[index.get(recipe)] == 0) {
                    q.add(index.get(recipe));
                }
            }
        }
        return cooked;
    }
}
