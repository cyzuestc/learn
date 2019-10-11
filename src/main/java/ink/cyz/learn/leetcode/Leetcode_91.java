package ink.cyz.learn.leetcode;


import ink.cyz.learn.leetcode.utils.ListNode;
import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_91 {

    @Test
    public void t(){
        String s = "101";
        System.out.println(numDecodings(s));
    }
    public int numDecodings(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c1 == '0')return 0;
            if (i+1<s.length() && s.charAt(i+1) == '0'){
                if (c1 > '2')return 0;
                i++;
            }else {
                sb.append(c1);
            }
        }
        System.out.println(sb.toString());
        char[] cs = sb.toString().toCharArray();
        int[] dp = new int[cs.length+1];
        dp[0] = 1;
        for (int i = 1; i <= cs.length; i++) {
            if (i == 1){
                dp[i] = 1;
                continue;
            }
            char c = cs[i-1];
            char cLast = cs[i-2];
            if (cLast == '1' || (cLast == '2' && c < '7')){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}


