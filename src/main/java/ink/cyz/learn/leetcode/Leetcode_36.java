package ink.cyz.learn.leetcode;

public class Leetcode_36 {

    public static void main(String[] args) {
        char[][] board =   {{'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};
        Leetcode_36 t = new Leetcode_36();
        System.out.println(t.isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')continue;
                boolean isValid = validSudoku(board,i,j);
                if (!isValid){
                    System.out.println(i+" "+j);
                    return false;
                }
            }
        }
        return true;
    }
    private boolean validSudoku(char[][] board, int i, int j) {
        char c = board[i][j];
        for (int k = 0; k < board.length && k != i; k++) {
            if (board[k][j] == c){
                System.out.println(k+" "+j);
                return false;
            }
        }
        for (int k = 0; k < board[0].length && k != j; k++) {
            if (board[i][k] == c){
                System.out.println(i+" "+k);
                return false;
            }
        }
        int starti = i/3*3;
        int startj = j/3*3;

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (k+starti == i && l+startj == j)continue;
                if (board[k+starti][l+startj] == c){
                    return false;
                }
            }
        }
        return true;
    }
}
