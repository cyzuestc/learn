package ink.cyz.learn.leetcode;

public class Leetcode_48 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swapUpDown(matrix,i,j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                swapLeftRight(matrix,i,j);
            }
        }
    }

    private void swapLeftRight(int[][] matrix, int i, int j) {
        matrix[i][j] = matrix[i][j] ^ matrix[j][i] ^ (matrix[j][i] = matrix[i][j]);
    }

    private void swapUpDown(int[][] matrix, int i, int j) {
        matrix[i][j]  =  matrix[matrix.length-1-i][j] ^ matrix[i][j] ^ ( matrix[matrix.length-1-i][j] = matrix[i][j]);
    }
}
