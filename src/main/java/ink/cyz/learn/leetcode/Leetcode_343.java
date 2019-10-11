package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_343 {
    @Test
    public void t(){
        System.out.println(integerBreak(58));
    }
    public int integerBreak(int n) {
        if (n == 2)return 1;
        if (n == 3)return 2;
        int[] dp = new int[n+1];
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= n ; i++) {
            for (int j = 2; j <= i/2 ; j++) {
                dp[i] = Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}
