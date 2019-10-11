package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_947 {
    @Test
    public void t(){
        int[][] stone = {{0,0}};
        System.out.println(removeStones(stone));
    }
    int res = 0;
    public int removeStones(int[][] stones) {
        int[] dp = new int[stones.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        res = dp.length;
        for (int i = 0; i < stones.length; i++) {
            union(stones,dp,i);
            if (dp[i] == i)res--;
        }


        return res;
    }

    private void union(int[][] stones, int[] dp, int index) {
        int head = find(stones,dp,index);
        for (int i = 0; i < stones.length; i++) {
            if (stones[index][0]==stones[i][0]||stones[index][1]==stones[i][1]){
                int curHead = find(stones,dp,i);
                if (curHead!=head)res++;
                dp[curHead] = head;
            }
        }
    }

    private int find(int[][] stones, int[] dp,int index) {
        int head = index;
        while (dp[head] != head){
            head = dp[head];
        }
        while (dp[index] != index){
            int temp = dp[index];
            dp[index] = head;
            index = temp;
        }
        return head;
    }

}
