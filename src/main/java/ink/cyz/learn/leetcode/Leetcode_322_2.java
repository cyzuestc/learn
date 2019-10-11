package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_322_2 {
    @Test
    public void t(){

        System.out.println(coinChange(new int[]{186,419,83,408},6249));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0||coins.length == 0)return 0;
        int[] dp =new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int coin : coins){
            for (int i = coin; i <= amount ; i++) {
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1?-1:dp[amount];
    }

}
