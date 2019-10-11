package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;

public class Leetcode_37_4 {
    public void solveSudoku(char[][] board) {
        setup(board);
        solveSudokuHelp(board,0);
    }
    boolean solved = false;
    int index = 0;
    int[][] rows = new int[9][9+1];
    int[][] cols = new int[9][9+1];
    int[][] cells = new int[9][9+1];
    public void solveSudokuHelp(char[][] board,int start) {
        if (start>80){
            Utils.print(board);
            solved = true;
            return ;
        }
        int i = start/9;
        int j = start%9;

        if (board[i][j] == '.'){
            System.out.println(start);
            for (int k = 1; k <= 9 ; k++) {
                if (validSudoku(board,i,j, k)) {
                    placeNum(board,i,j,k);
                    solveSudokuHelp(board,start+1);
                    if (!solved)removeNum(board,i,j,k);
                }
            }
        }else {
            solveSudokuHelp(board,start+1);
        }
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')continue;
                boolean isValid = validSudoku(board,i,j,board[i][j]);
                if (!isValid){
                    return false;
                }
            }
        }
        return true;
    }
    private void placeNum(char[][] board, int i, int j, int c){
        rows[i][c]++;
        cells[i/3*3+j/3][c]++;
        cols[j][c]++;
        board[i][j] = (char) ('0'+c);
    }
    private void removeNum(char[][] board, int i, int j,int c){
        rows[i][c]--;
        cells[i/3*3+j/3][c]--;
        cols[j][c]--;
        board[i][j] = '.';
    }
    public void setup(char[][] board) {
        int rowL = board.length;
        int colL = board[0].length;
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                if (board[i][j] == '.')continue;
                int c = board[i][j] - '0';
                int cellsNum = ++cells[i/3*3+j/3][c];
                int colsNum = ++cols[j][c];
                int rowsNum = ++rows[i][c];
            }
        }
    }
    private boolean validSudoku(char[][] board, int i, int j,int c) {
        return rows[i][c]+cells[i/3*3+j/3][c]+cols[j][c] == 0;
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

        Leetcode_37_4 t = new Leetcode_37_4();
        t.solveSudoku(board1);
        Utils.print(board1);
    }
}
