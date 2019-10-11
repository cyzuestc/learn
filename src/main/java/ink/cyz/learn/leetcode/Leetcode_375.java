package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.Arrays;

public class Leetcode_375 {
    @Test
    public void t(){
        System.out.println(getMoneyAmount(20));
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >=1 ; j--) {
                if (j == i-1){
                    dp[j][i] = j;
                    continue;
                }
                if (j<i)dp[j][i] = Integer.MAX_VALUE;
                for (int k = (i+j+1)/2; k < i ; k++) {
                    dp[j][i] = Math.min(dp[j][i],Math.max(dp[j][k-1],dp[k+1][i])+k);
                }
            }
        }
        Utils.print(dp);
        return dp[1][n];
    }

}
