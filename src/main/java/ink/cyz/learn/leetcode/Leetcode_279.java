package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      : Zink
 * @ Date        : Created in 21:19 2019/8/28
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_279 {

    @Test
    public void t(){
        System.out.println(numSquares(12));
    }
    public int numSquares(int n){
        int[] dp =new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            int j = 1;
            while (i-j*j>=0){
                dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
                j++;
            }
        }
        return dp[n];
    }
}
