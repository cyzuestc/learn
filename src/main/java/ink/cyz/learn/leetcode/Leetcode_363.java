package ink.cyz.learn.leetcode;

import org.junit.Test;


public class Leetcode_363 {
    @Test
    public void t(){
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j+1] = dp[i][j]+matrix[i][j];
            }
        }

        int maxK = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <=n ; j++) {
                int[] d = new int[m];
                for (int l = 0; l < m; l++) {
                    d[l] = dp[l][j]-dp[l][i];
                    maxK = getMaxSumNoGreaterThenK(d,k);
                }
            }
        }



        return 0;
    }

    /**
     * 从数组中找到 连续子数组 不大于K的最大值
     * @param i
     * @param k
     * @return
     */
    private int getMaxSumNoGreaterThenK(int[] a, int k) {
        int i = 0;
        int j = 1;
        int sum = a[0];
        return 0;

    }
}
