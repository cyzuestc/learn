package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 21:19 2019/8/28
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_304 {
    int[][] dp;
    public Leetcode_304(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int num = matrix[i][j];
                int left = j==0?0:dp[i][j-1];
                int up = i==0?0:dp[i-1][j];
                int leftUp = i==0||j==0?0:dp[i-1][j-1];

                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
            }
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2][col2]+dp[row1][col1]-dp[row1][col2]-dp[row2][col1];
    }
}

