package ink.cyz.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_322 {
    @Test
    public void t(){

        System.out.println(coinChange(new int[]{186,419,83,408},6249));
    }

    Map<Integer,Integer> map = new HashMap();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0||coins.length == 0)return 0;

        map.put(0,0);
        int minCoin = coins[0];
        int maxCoin = minCoin;
        for(int coin : coins){
            map.put(coin,1);
            minCoin = Math.min(minCoin,coin);
            maxCoin = Math.max(maxCoin,coin);
        }
        int c =bf(coins,amount,minCoin,maxCoin);
        System.out.println(map);
        return c;
    }

    private int bf(int[] coins, int amount,int minCoin,int maxCoin) {
        if (minCoin > amount)return -1;
        if (map.containsKey(amount))return map.get(amount);

//        int maxTimes = amount/maxCoin;
//        if (maxTimes > 10)return maxTimes-10+ bf(coins,amount-maxCoin*(maxTimes-10),minCoin,maxCoin);

        int minNum = Integer.MAX_VALUE;
        for (int coin : coins){
            if (amount-coin < minCoin)continue;
            Integer cur = map.get(amount-coin);
            if (cur == null) {
                cur = bf(coins,amount-coin,minCoin,maxCoin);
                map.put(amount-coin,cur);
            }

            if (cur == -1)continue;
            else minNum = Math.min(minNum,cur+1);
        }
        if (minNum == Integer.MAX_VALUE)minNum = -1;
        map.put(amount,minNum);
        return minNum;
    }
}
