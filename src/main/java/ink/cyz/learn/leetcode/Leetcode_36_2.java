package ink.cyz.learn.leetcode;

public class Leetcode_36_2 {
    public boolean isValidSudoku(char[][] board) {
        int rowL = board.length;
        int colL = board[0].length;
        int[][] rows = new int[rowL][colL+1];
        int[][] cols = new int[rowL][colL+1];
        int[][] cells = new int[rowL][colL+1];
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                if (board[i][j] == '.')continue;
                int c = board[i][j] - '0';
                int rowsNum = ++rows[i][c];
                int colsNum = ++cols[j][c];
                int cellsNum = ++cells[i/3*3+j/3][c];
            }
        }
        return true;
    }
}
