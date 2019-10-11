package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_96 {
    @Test
    public void t(){
        System.out.println(numTrees(4));
    }
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
            dp[i] += dp[i-1];
        }
        return dp[n];
    }
}
