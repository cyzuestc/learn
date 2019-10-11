package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;

public class Leetcode_37_2 {
    public static void main(String[] args) {
        char[][] board1 = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        Leetcode_37_2 t = new Leetcode_37_2();
        t.solveSudoku(board1);
        Utils.print(board1);
        System.out.println(t.index);
    }

    boolean solved = false;
    int index = 0;
    int[][] rows = new int[9][9+1];
    int[][] cols = new int[9][9+1];
    int[][] cells = new int[9][9+1];

    public void solveSudoku(char[][] board) {
        setup(board);
        backtrack(board, 0);
    }
    public void backtrack(char[][] board, int start) {
//        Utils.print(board);
        index++;
        if (start > 80) {
            solved = true;
            return;
        }
        int i = start / 9;
        int j = start % 9;

        if (board[i][j] == '.') {
            for (int k =1; k <= 9; k++) {
                if (validSudoku(board, i, j,k)) {
                    placeNum(board,i,j,k);
                    backtrack(board,start+1);
                    if (!solved)
                    removeNum(board,i,j,k);
                }
            }
        }else backtrack(board,start+1);

    }
    private boolean validSudoku(char[][] board, int i, int j,int c) {
        return rows[i][c]+cells[i/3*3+j/3][c]+cols[j][c] == 0;
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





}
