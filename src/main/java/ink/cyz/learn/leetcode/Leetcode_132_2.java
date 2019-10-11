package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Leetcode_132_2 {

    @Test
            public void t(){
        System.out.println(minCut("aabbaaaaaaaaaaaaac"));
    }

    public int minCut(String s) {
        char[] c = s.toCharArray();
        int[] dp = new int[s.length()];
        Arrays.fill(dp,s.length()-1);
        for (int i = 0; i < s.length(); i++) {
            help(c,i,i,dp);
            help(c,i,i+1,dp);
        }
        return dp[dp.length-1];
    }

    private void help(char[] c, int i, int j, int[] dp) {
        while (i >= 0 && j <c.length && c[i] == c[j]){
            if (i == 0){
                dp[j] = 0;
            }else {
                dp[j] = Math.min(dp[i-1]+1,dp[j]);
            }
            i--;j++;
        }
    }
}
