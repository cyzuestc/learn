package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_1155 {
    @Test
    public void t(){
        System.out.println(numRollsToTarget(1,6,3));
    }
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d+1][target+1];
        dp[0][0] = 1;
//        骰子个数
        for (int i = 1; i <dp.length; i++) {
//            target值
            for (int j = 1; j <dp[0].length; j++) {
//                该骰子面值
                for (int k = 1; k <= f && j>=k; k++) {
                    dp[i][j] += dp[i-1][j-k];
                    dp[i][j] %= 1000000007;
                }
            }
        }
//        Utils.print(dp);
        return dp[d][target];
    }

}
