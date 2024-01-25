public class ComplementofBase10Integer {
    public static void main(String[] args) {
        ComplementofBase10Integer solution = new ComplementofBase10Integer();
        int n = 10;
        int ans = solution.input(n);
        System.out.println(ans);
    }

    public int input(int n) {
        // edge Case
        if (n == 0)
            return 1;

        int m = n;
        int mask = 0;

        while (m != 0) {
            mask = (mask << 1) | 1; // calculating mask
            m = m >> 1;
        }
        int ans = ~n & mask;
        return ans;
    }
}

// ~n or can be said as NOT of n reverses all the bits of the number
// ~n 或可以說是 NOT of n 反轉數字的所有位
// we will write shift until our no. is not equal to zero so that we can find
// how many bits have our answer
// 我們將寫入shift直到我們的編號。不等於零，這樣我們就可以找到有多少位有我們的答案
// to create mask so that all the 0 bits in left side which got 1 when we NOT
// them, must be done 0 again
// 建立掩碼，以便左側所有 0 位元在我們不是它們時變為 1，必須再次變為 0
// and if we know how many bits have our answer than remaining bits can be AND
// with 0
// 如果我們知道有多少位有答案，那麼剩餘的位元可以與 0 進行 AND 運算
// Example:- 5 :- (representing in 16 bit) 0000000000000101
// 範例:- 5 :- (以16位元表示) 0000000000000101
// mask:- 3 digits, how to calculate:- use right shift until number is zero like
// 遮罩：- 3 位數字，如何計算：- 使用右移直到數字為零
// 0000000000000010 >> 1
// 0000000000000001 >> 1
// 0000000000000000

// so to make our final answer starting bit as zero we need
// 因此，為了使我們的最終答案起始位元為零，我們需要
// mask right most 3 bits to be 1 and remaining zero
// 將最右邊的 3 位元遮罩為 1，其餘為 0

// 000000000000000 << 1 OR 1
// 000000000000001 << 1 OR 1
// 000000000000011 << 1 OR 1
// 000000000000111, 3 time because we calculated masked digit to be 3
// 000000000000111，3次，因為我們計算出屏蔽數字為3
// and in last do AND with mask;
// 最後與 mask 進行 AND 操作；
