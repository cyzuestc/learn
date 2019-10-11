package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_5126 {
    @Test
    public void t(){
        System.out.println(countVowelPermutation(144));
    }
    public int countVowelPermutation(int n) {
        int[][] dp = new int[5][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 5; i++) {
                if (j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                int cur = 0;
                switch (i){
                    case 0:cur = (dp[1][j-1]+dp[2][j-1])%1000000007+dp[4][j-1];
                    break;
                    case 1:cur = dp[0][j-1]+dp[2][j-1];
                    break;
                    case 2:cur = dp[1][j-1]+dp[3][j-1];
                    break;
                    case 3:cur = dp[2][j-1];
                    break;
                    case 4:cur = dp[2][j-1]+dp[3][j-1];
                    break;
                }
                dp[i][j] = cur%1000000007;
            }
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += dp[i][n-1];
            res %= 1000000007;
        }
        return res;
    }
}
