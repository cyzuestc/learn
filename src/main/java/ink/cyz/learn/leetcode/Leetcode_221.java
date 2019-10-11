package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;

/**
 * @ Author      : Zink
 * @ Date        : Created in 11:40 2019/8/24
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_221 {
    public static void main(String[] args) {
        Leetcode_221 t = new Leetcode_221();

        char[][] m = {{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}};
        System.out.println(t.maximalSquare(m));
    }
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                    continue;
                }
                int up = i==0?0:dp[i-1][j];
                int left = j==0?0:dp[i][j-1];
                int upLeft = i==0||j==0?0:dp[i-1][j-1];

                int minNeighborhood = Math.min(up,Math.min(left,upLeft));
                dp[i][j] =minNeighborhood+1;
                res = Math.max(res,dp[i][j]);
            }
        }
        return res*res;
    }



}
