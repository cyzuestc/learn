package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.Arrays;

public class Leetcode_1162 {
    @Test
    public void t(){
        int[][] g = 
                {{0,0,1,1,1},{0,1,1,0,0},{0,0,1,1,0},{1,0,0,0,0},{1,1,0,0,1}}
        ;
        System.out.println(maxDistance(g));
    }
    public int maxDistance(int[][] grid) {
        int res = -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        Utils.print(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    dp[i+1][j+1] = 0;
                    continue;
                }
                int left = dp[i+1][j];
                int up = dp[i][j+1];
                if (left==-1&&up==-1)dp[i+1][j+1] = -1;
                else if (left!=-1&&up!=-1){
                    dp[i+1][j+1] = Math.min(left,up)+1;
                }else {
                    dp[i+1][j+1] = Math.max(left,up)+1;
                }
            }
        }
        Utils.print(dp);
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == 1){
                    continue;
                }

                int right  = (j+2>dp[0].length-1?-1:dp[i+1][j+2]);
                int down = (i+2>dp.length-1?-1:dp[i+2][j+1]);
                int temp = 0;
                if (right==-1&&down==-1)temp = -1;
                else if (right!=-1&&down!=-1){
                    temp = Math.min(right,down)+1;
                }else {
                    temp = Math.max(right,down)+1;
                }

                if (temp != -1){
                    if (dp[i+1][j+1] != -1)dp[i+1][j+1] = Math.min(dp[i+1][j+1],temp);
                    else dp[i+1][j+1] = temp;
                }
                res = Math.max(res,dp[i+1][j+1]);
            }
        }
        Utils.print(dp);
        return res;
    }
}
