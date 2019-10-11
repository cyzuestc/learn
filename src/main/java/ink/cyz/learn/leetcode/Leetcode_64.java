package ink.cyz.learn.leetcode;


public class Leetcode_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m==0)return 0;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0)dp[j]=grid[i][j];
                else if (i==0){
                    dp[j] = dp[j-1]+grid[i][j];
                }else if (j == 0){
                    dp[j] = dp[j]+grid[i][j];
                }else {
                    dp[j] = Math.min(dp[j-1],dp[j])+grid[i][j];
                }
            }
        }
        return dp[n-1];
    }
}
