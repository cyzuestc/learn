package ink.cyz.learn.leetcode;


public class Leetcode_72 {
    public int minDistance(String word1, String word2) {
        char[] cm = word1.toCharArray();
        char[] cn = word2.toCharArray();
        int m = cm.length;
        int n = cn.length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1+dp[i-1][0];
        }
        for (int i = 1; i <=n ; i++) {
            dp[0][i] = 1+dp[0][i-1];
        }

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isSame = cm[i-1] == cn[j-1];
                int minLeftUp = Math.min(dp[i-1][j],dp[i][j-1]);

                if (isSame)dp[i][j] = Math.min(dp[i-1][j-1],minLeftUp+1);
                else {
                    dp[i][j] = Math.min(minLeftUp,dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
}
