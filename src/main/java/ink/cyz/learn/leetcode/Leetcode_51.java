package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_51 {

    @Test
    public void test(){
        boolean[][] t = {{false,false,false,false},{false,false,false,false},{false,true,false,false},{false,false,false,false}};
        Assert.assertEquals(valid(0,t),true);
    }

    @Test
    public void t (){
        solveNQueens(12);
        System.out.println(res.size());
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[][]  board = new boolean[n][n];
        help(0,board);
        return res;
    }

    private void help(int index, boolean[][] board) {
        int N = board.length;
        if (index== N*N){
            addSolution(board);
            return ;
        }
        int row = index/N;
        for (int i = 0; i < N; i++) {
            if (valid(index+i,board)){
                board[row][i] = true;
                help(row*N+N, board);
                board[row][i]=false;
            }
        }
    }

    private boolean valid(int count, boolean[][] board){
//        Utils.print(board);
        int N = board.length;
        int row = count/N;
        int col = count%N;

        //每一行 每一列
        for (int i = 0; i < N; i++) {
            if (board[i][col] || board[row][i] )return false;
        }
        //每一/
        for (int i = 0; i < N; i++) {
            if (inBoundary(row+col-i,N)){
                if (board[i][row+col-i])return false;
            }
        }
        //每一\
        for (int i = 0; i < N; i++) {
            if (inBoundary(col-row+i,N)) {
                if (board[i][col - row + i]) return false;
            }
        }
        return true;
    }

    private boolean inBoundary(int i,int N){
        return i>=0 && i<N;
    }

    private void addSolution(boolean[][] board) {
//        Utils.print(board);
        ArrayList<String> list= new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j])s.append('Q');
                else s.append('.');
            }
            list.add(s.toString());
        }
        res.add(list);
    }
}
