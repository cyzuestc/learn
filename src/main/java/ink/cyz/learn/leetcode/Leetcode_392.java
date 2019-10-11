package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_392 {
    @Test
    public void t(){

    }
//  s = "abc", t = "ahbgdc"
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)return true;
        if (t.length() == 0)return false;
        int[]dp = new int[t.length()+1];
        dp[0] = 0;
        int index = 0;
        char cShort = s.charAt(index);
        for (char cLong : t.toCharArray()) {
            if (cShort == cLong){
                index++;
                if (index == s.length())return true;
                cShort = s.charAt(index);
            }
        }
        return false;
    }
}
