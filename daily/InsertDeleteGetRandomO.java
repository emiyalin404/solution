import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InsertDeleteGetRandomO {
    public static void main(String[] args) {
        InsertDeleteGetRandomO randomizedSet = new InsertDeleteGetRandomO(); // 创建 RandomizedSet 实例

        randomizedSet.insert(1); // 调用 insert 方法，插入 1
        randomizedSet.remove(2); // 调用 remove 方法，移除 2（2 不在集合中，返回 false）
        randomizedSet.insert(2); // 调用 insert 方法，插入 2
        randomizedSet.getRandom(); // 调用 getRandom 方法，随机获取集合中的一个元素
        randomizedSet.remove(1); // 调用 remove 方法，移除 1（1 在集合中，返回 true）
        randomizedSet.insert(2); // 调用 insert 方法，插入 2（2 已在集合中，返回 false）
        randomizedSet.getRandom(); // 调用 getRandom 方法，随机获取集合中的一个元素
        System.out.println(randomizedSet.toString());
    }

    List<Integer> data;
    Random rand;

    public InsertDeleteGetRandomO() {
        data = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (data.contains(val)) {
            return false;
        }
        return true;
    }

    public boolean remove(int val) {
        // if (!data.contains(val)) {
        // return false;
        // } else {
        // data.remove(val);
        // return true;
        // }
        return data.remove(Integer.valueOf(val));
    }

    public int getRandom() {
        return data.get(rand.nextInt(data.size()));
    }

    // private List<Integer> data;
    // private Map<Integer, Integer> indexMap;
    // private Random rand;

    // public InsertDeleteGetRandomO() {
    // data = new ArrayList<>();
    // indexMap = new HashMap<>();
    // rand = new Random();
    // }

    // public boolean insert(int val) {
    // if (indexMap.containsKey(val)) {
    // return false;
    // }

    // data.add(val);
    // indexMap.put(val, data.size() - 1);
    // return true;
    // }

    // public boolean remove(int val) {
    // if (!indexMap.containsKey(val)) {
    // return false;
    // }

    // int indexToRemove = indexMap.get(val);
    // int lastElement = data.get(data.size() - 1);

    // data.set(indexToRemove, lastElement);
    // indexMap.put(lastElement, indexToRemove);

    // data.remove(data.size() - 1);
    // indexMap.remove(val);

    // return true;
    // }

    // public int getRandom() {
    // int randomIndex = rand.nextInt(data.size());
    // return data.get(randomIndex);
    // }

}
