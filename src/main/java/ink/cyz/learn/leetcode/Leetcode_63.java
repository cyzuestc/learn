package ink.cyz.learn.leetcode;


public class Leetcode_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)return 1;
        int n = obstacleGrid[0].length;

        if(m<1||n<1)return 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            if (obstacleGrid[0][i]==1)
            dp[i]=0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int obs = obstacleGrid[i][j];
                if (obs == 1){
                    dp[j] = 0;
                }else {
                    if (j==0)dp[j]=dp[j];
                    else {
                        dp[j] = dp[j-1]+dp[j];
                    }
                }
            }
        }
        return dp[n-1];
    }
}
