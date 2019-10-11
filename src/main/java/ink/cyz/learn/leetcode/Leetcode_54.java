package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_54 {
    @Test
    public void t(){
        int[][] t = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(t));
    }
    List<Integer> res = new ArrayList<>();
    int i = 0,j = 0;
    int arrow = 0;
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] map = new boolean[row][col];
        while (isOk(matrix,map,row,col)){
        }
        return res;
    }

    private boolean isOk(int[][] matrix, boolean[][] map, int row, int col) {
        System.out.println(i+" "+j);
        if (i<0||i==row||j<0||j==col)return false;
        res.add(matrix[i][j]);
        map[i][j] = true;
        switch (arrow){
            case 0:
                if (j+1>=col || map[i][j+1]){
                    arrow++;
                    i++;
                }else {
                    j++;
                }
                break;
            case 1:
                if (i+1>=row || map[i+1][j]){
                    arrow++;
                    j--;
                }else {
                    i++;
                }break;
            case 2:
                if (j==0 || map[i][j-1]){
                    arrow++;
                    i--;
                }else {
                    j--;
                }break;
            case 3:
                if (i==0 || map[i-1][j]){
                    arrow=0;
                    j++;
                }else {
                    i--;
                }break;
        }
        if (map[i][j])return false;
        return true;
    }

}
