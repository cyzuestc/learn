package ink.cyz.learn.leetcode;

public class Leetcode_338 {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i]>>1+(i%2);
        }
        return dp;
    }
}
