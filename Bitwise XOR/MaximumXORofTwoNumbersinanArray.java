import java.util.HashSet;

public class MaximumXORofTwoNumbersinanArray {
    public static void main(String[] args) {
        MaximumXORofTwoNumbersinanArray solution = new MaximumXORofTwoNumbersinanArray();
        int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
        int ans = solution.input(nums);
        System.out.println(ans);
    }

    public int input(int[] nums) {
        // int a = 0;
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = 1; j < nums.length; j++) {
        // int ans = nums[i] ^ nums[j];
        // a = Math.max(a, ans);
        // }
        // }
        // return a;

        int result = 0;
        int mask = 0;
        int i = 31;

        // 讓我們檢查每個可能的正整數
        while (i >= 0) {
            // 遮罩從最高有效位元開始-1, 01000...00,->01100...00,->>>>>> 01111...11
            mask = mask | (1 << i);
            // 我們已經有了一個結果，只需將結果的有效位位置再向右擴展即可
            // 例如：0110100..00是結果，讓我們檢查0110110..00是否是結果
            // 讓我們檢查candidateResult是否可能？
            int candidate = result | (1 << i); // (candidateResult作為候選結果)

            // 記錄所有前綴（我們只需要操作特定的位元位置即可）
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }

            // 讓我們檢查每個前綴
            for (int prefix : set) {

                // so..如果candidateResult是已經存在的結果，那怎麼會發生呢？
                // 棘手的觀點是：
                // A^B = 候選結果 <=> B^candidateResult = A
                if (set.contains(candidate ^ prefix)) {

                    // 這是可能的，所以儲存這個結果
                    result = candidate;
                    break;
                }
            }
            i--;
        }
        return result;
    }
}
