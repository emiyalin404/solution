
// import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        ThreeSumWithMultiplicity solution = new ThreeSumWithMultiplicity();
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        int target = 8;
        int ans = solution.input(arr, target);
        System.out.println(ans);
    }

    public int input(int[] arr, int target) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr);
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                if (arr[i] + arr[l] + arr[r] == target && arr[l] != arr[r]) {
                    int x = 1, y = 1;
                    int j = l + 1, k = r - 1;
                    while (j < r && arr[l] == arr[j]) {
                        x++;
                        j++;
                    }
                    while (k > l && arr[r] == arr[k]) {
                        y++;
                        k--;
                    }
                    l = j;
                    r = k;
                    count += x * y;
                } else if (arr[i] + arr[l] + arr[r] < target) {
                    l++;
                } else if (arr[i] + arr[l] + arr[r] > target) {
                    r--;
                } else {
                    count += (-l + r + 1) * (-l + r) / 2;
                    break;
                }
            }
        }

        int ans = (int) (count % (1000000000 + 7));
        return ans;

        // long count = 0;
        // for (int i = 0; i < arr.length; i++) {
        // Arrays.sort(arr);
        // int l = i + 1;
        // int r = arr.length - 1;
        // while (l < r) {
        // if (arr[i] + arr[l] + arr[r] == target && arr[l] != arr[r]) {
        // int y = 1, x = 1;
        // int j = l + 1, k = r - 1;
        // while (j < r && arr[l] == arr[j]) {
        // x++;
        // j++;
        // }
        // while (k > l && arr[r] == arr[k]) {
        // y++;
        // k--;
        // }
        // l = j;
        // r = k;
        // count += x * y;
        // } else if (arr[i] + arr[l] + arr[r] < target)
        // l++;
        // else if (arr[i] + arr[l] + arr[r] > target)
        // r--;
        // else {
        // count += (-l + r + 1) * (-l + r) / 2;
        // break;
        // }
        // }
        // }
        // int ans = (int) (count % (1000000000 + 7));
        // return ans;

        // long count = 0;
        // for (int i = 0; i < arr.length; i++) {

        // Arrays.sort(arr);
        // int start = i + 1;
        // int end = arr.length - 1;
        // while (start < end) {
        // if (arr[i] + arr[start] + arr[end] == target && arr[start] != arr[end]) {
        // int y = 1, x = 1;
        // int j = start + 1, k = end - 1;
        // while (j < end && arr[start] == arr[j]) {
        // x++;
        // j++;
        // }
        // while (k > start && arr[end] == arr[k]) {
        // y++;
        // k--;
        // }
        // start = j;
        // end = k;
        // count += x * y;
        // } else if (arr[i] + arr[start] + arr[end] < target)
        // start++;
        // else if (arr[i] + arr[start] + arr[end] > target)
        // end--;
        // else {
        // count += (-start + end + 1) * (-start + end) / 2;
        // break;
        // }
        // }
        // }
        // // count = count+x;
        // int ans = (int) (count % (1000000000 + 7));
        // return ans;
    }
}
