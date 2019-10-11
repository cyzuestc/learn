package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;

import java.util.Arrays;

public class Leetcode_37 {
    public void solveSudoku(char[][] board) {
       solveSudokuHelp(board,0);
    }
    boolean solved = false;
    public void solveSudokuHelp(char[][] board,int start) {
        if (start>80){
            Utils.print(board);
            solved = true;
            return ;
        }
        int i = start/9;
        int j = start%9;

        if (board[i][j] == '.'){
            for (int k = 1; k <= 9 ; k++) {

                    board[i][j] = (char) (k+'0');
                    solveSudokuHelp(board,start+1);
                    if (!solved)board[i][j] = '.';
            }
        }else solveSudokuHelp(board,start+1);
    }

    public static void main(String[] args) {
        char[][] board1 =   {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};

        Leetcode_37 t = new Leetcode_37();
        t.solveSudoku(board1);
        Utils.print(board1);
    }

}
