import java.util.HashMap;
// import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        FruitIntoBaskets solution = new FruitIntoBaskets();
        int[] fruits = { 0, 1, 2, 2 };
        int ans = solution.input(fruits);
        System.out.println(ans);

    }

    public int input(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ws = 0, max = -1, i = 0;
        for (i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                max = Math.max(i - ws, max);
                map.put(fruits[ws], map.get(fruits[ws]) - 1);
                if (map.get(fruits[ws]) == 0) {
                    map.remove(fruits[ws]);
                }
                ws += 1;
            }
        }
        max = Math.max(max, i - ws);
        return max;
        // int maxNoOfTrees = 1;
        // int bucket1 = fruits[0];
        // int bucket2 = fruits[0];
        // HashMap<Integer, Integer> mapIndex = new HashMap<>();
        // int pickedReomTreesSoFar = 1;
        // mapIndex.put(bucket1, 0);
        // for (int i = 1; i < fruits.length; i++) {
        // int fruitSize = fruits[i];
        // if (fruitSize == bucket1 || fruitSize == bucket2) {
        // pickedReomTreesSoFar++;
        // mapIndex.put(fruitSize, i);
        // } else if (bucket1 == bucket2) {
        // pickedReomTreesSoFar++;
        // bucket2 = fruitSize;
        // mapIndex.put(fruitSize, i);
        // } else {
        // if (bucket1 == fruits[i - 1]) {
        // pickedReomTreesSoFar = (i - mapIndex.remove(bucket2));
        // bucket2 = fruitSize;
        // } else {
        // pickedReomTreesSoFar = (i - mapIndex.remove(bucket1));
        // bucket1 = fruitSize;
        // }
        // mapIndex.put(fruitSize, i);
        // }
        // maxNoOfTrees = Math.max(maxNoOfTrees, pickedReomTreesSoFar);

        // }
        // return maxNoOfTrees;
    }
}
