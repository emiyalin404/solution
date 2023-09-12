public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int ans = solution.input(height);
        System.out.println(ans);
    }

    public int input(int[] height) {
        int fast = 0;
        int last = height.length - 1;
        int maxsize = 0;
        while (fast < last) {
            int w = last - fast;
            int h = Math.min(height[fast], height[last]);
            int capa = h * w;
            maxsize = Math.max(maxsize, capa);
            if (height[fast] < height[last]) {
                fast++; // 移动较短的指针
            } else {
                last--; // 移动较长的指针
            }
        }
        return maxsize;
        // int width = 0;
        // for (int i = 0; i < height.length; i++) {
        // for (int j = i + 1; j < height.length; j++) {
        // int h = Math.min(height[i], height[j]);
        // int w = j - i;
        // int capa = h * w;
        // width = Math.max(width, capa);
        // }
        // }
        // return width;
    }
}
