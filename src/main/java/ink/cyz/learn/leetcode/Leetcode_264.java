package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 21:21 2019/8/27
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_264 {
    public int nthUglyNumber(int n) {
        int u2 = 0;
        int u3 = 0;
        int u5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i <n; i++) {
            dp[i] = Math.max(dp[u2]*2,Math.max(dp[u3]*3,dp[u5]*5));
            if (dp[i] == dp[u2]*2)u2++;
            if (dp[i] == dp[u3]*3)u3++;
            if (dp[i] == dp[u5]*5)u5++;
        }
        return dp[n-1];
    }
}
