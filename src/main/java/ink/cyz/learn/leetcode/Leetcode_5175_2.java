package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

public class Leetcode_5175_2 {
    @Test
    public void t(){
    }

    public int getBinary(char c){
        int num = c - 'a';
        return (int) Math.pow(2,num);
    }
    public int generateNum(int a,int b){
        return (a|b)-(a&b);
    }

    public int count(int num){
        int res = 0;
        while (num > 0){
            res += (num & 1)==1?1:0;
        }
        return res;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int[] dp = new int[s.length()];
        for (int i = 0; i < cs.length; i++) {
            int num = getBinary(cs[i]);
            if (i == 0)dp[i] = num;
            else dp[i] = generateNum(dp[i-1],num);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries){
            res.add(help(dp,query[0],query[1],query[2]));
        }
        return res;
    }

    private Boolean help(int[] dp, int i, int j, int k) {
        if (i == 0){
            return k >= count(dp[j])/2;
        }else {
            return k >= count(dp[j] ^ dp[i-1])/2;
        }
    }

}
