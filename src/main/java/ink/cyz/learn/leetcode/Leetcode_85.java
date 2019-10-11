package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 17:30 2019/8/24
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_85 {

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)return 0;
        int col = matrix[0].length;

        int[][]dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean is0 = matrix[i][j] == '0';
                if (i == 0){
                    dp[i][j] = is0?0:1;
                }else {
                    if (is0){
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = dp[i-1][j]+1;
                    }
                }
            }
        }
        //dp结束
        int max = 0;
        for (int i = 0; i < row; i++) {
            max = Math.max(max,largestRectangleArea(dp[i]));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        return help(heights,0,heights.length-1);
    }

    public int help(int[] heights,int i,int j){
        if (heights.length <1)return 0;
        if (i == j)return heights[i];
        boolean sorted = true;
        int minIndex = i;
        for (int k = i+1; k <= j; k++) {
            if (sorted && heights[k] < heights[k-1]){
                sorted = false;
            }
            if(heights[k] < heights[minIndex]){
                minIndex = k;
            }
        }

        if(sorted){
            int max = 0;
            for(int k = i;k<=j;k++){
                max = Math.max(max,heights[k]*(j-k+1));
            }
            return max;
        }

        int l = (minIndex>i)?help(heights,i,minIndex-1):0;
        int r = (minIndex<j)?help(heights,minIndex+1,j):0;
        return Math.max(Math.max(l,r),heights[minIndex]*(j-i+1));
    }
}
