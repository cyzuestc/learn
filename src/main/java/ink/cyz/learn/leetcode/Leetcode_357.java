package ink.cyz.learn.leetcode;

public class Leetcode_357 {
    public int countNumbersWithUniqueDigits(int n) {
        /**
        1 0-9 10
        2 10-99 9*9
        3 100-999 9*9*8
        4 1000-9999 9*9*8*7
         */
        if (n == 0)return 1;
        if (n == 1)return 10;
        if (n == 2)return 91;
        int[] dp = new int[n+1];
//        dp[0] = 1;
        dp[1] = 10;
        dp[2] = 9*9;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] * (11-n);
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
