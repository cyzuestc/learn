package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_5071 {
    @Test
    public void t(){

    }
    public int smallestCommonElement(int[][] mat) {
        int[] dp = new int[mat.length];
        boolean isBigger = false;
        for (int i = 0; i < mat[0].length; i++) {
            int common = mat[0][i];
            for (int j = 0; j < mat.length; j++) {
                dp[j] = checkExist(mat,j,common,dp[j]);
                if (dp[j] == mat[0].length)return -1;
                if (mat[j][dp[j]]!=common){
                    isBigger = true;
                    break;
                }
            }
            if (!isBigger)
            return common;
        }
        return -1;
    }

    private int checkExist(int[][] mat, int i, int common, int start) {
        for (int j = start; j <  mat[0].length; j++) {
            if (mat[i][j] >= common){
                return j;
            }
        }
        return mat[0].length;
    }
}
