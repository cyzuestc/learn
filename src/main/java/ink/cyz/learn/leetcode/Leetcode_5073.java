package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_5073 {
    @Test
    public void t(){
        System.out.println(minKnightMoves(8,8));
    }
    public int minKnightMoves(int x, int y) {
        if(x<0)x = -x;
        if(y<0)y = -y;
        int[][]dp = new int[x+2][y+2];
        dp[1][1] = 2;
        dp[0][1] = 3;
        dp[1][0] = 3;
        dp[0][2] = 2;
        dfs(dp,0,0);
        Utils.print(dp);
        return dp[x-1][y-1];
    }

    private void dfs(int[][] dp, int i, int j) {
        check(dp,i+2,j-1,dp[i][j]+1);
        check(dp,i+2,j+1,dp[i][j]+1);

        check(dp,i+1,j-2,dp[i][j]+1);
        check(dp,i+1,j+2,dp[i][j]+1);
    }

    private void check(int[][] dp, int i, int j, int step) {
        if (i<0||j<0||i>=dp.length||j>=dp[0].length||(i==0&&j==0))return ;
        if (dp[i][j] == 0||dp[i][j]>step){
            dp[i][j] = step;
            dfs(dp,i,j);
        }
    }


}
