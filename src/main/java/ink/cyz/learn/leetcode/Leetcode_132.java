package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_132 {

    @Test
            public void t(){
        System.out.println(minCut("aabbaaaaaaaaaaaaac"));
    }

    Integer[][] dp ;
    char[] cs;
    public int minCut(String s) {
        cs = s.toCharArray();
        dp = new Integer[s.length()+1][s.length()+1];
        return help(0,s.length())-1;
    }

    private int help( int i, int j) {
        if (dp[i][j] != null)return dp[i][j];

        if (isP(i,j-1)){
            dp[i][j] = 1;
            return dp[i][j];
        }
        int min = cs.length;
        for (int k = i+1; k < j; k++) {
            Integer left = dp[i][k];
            if (left == null){
                dp[i][k] = help(i,k);
                left = dp[i][k];
            }
            Integer right = dp[k][j];
            if (right == null){
                dp[k][j] = help(k,j);
                right = dp[k][j];
            }
            min = Math.min(left+right,min);
            if (min == 2)return min;
        }
        return min;
    }

    private boolean isP(int i,int j) {
        while (i<j){
            if (cs[i] != cs[j])return false;
            i++;
            j--;
        }
        return true;
    }
}
