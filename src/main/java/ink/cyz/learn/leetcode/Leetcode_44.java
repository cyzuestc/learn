package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_44 {
    @Test
    public void t(){
        String s = "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb"

        ;
        String p =
        "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a";

        System.out.println(isMatch(s,p));
    }
    public boolean isMatch(String s, String p) {
        StringBuilder newP = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*'){
                while (i+1<p.length() && p.charAt(i) == p.charAt(i+1))i++;
             }
             newP.append(p.charAt(i));
        }
        dict = new int[s.length()+1][newP.toString().length()+1];
        return help(s,0,newP.toString(),0);
    }
    int index = 0;
    int[][] dict ;
    public boolean help(String s, int s_i, String p, int p_i) {
        System.out.println(index++);
        //p匹配完了,s_i必须等于s长度
        if (p_i>=p.length())return s_i>=s.length();
        //s匹配完了,p只能是空或者'*'
        if (s_i>=s.length())return p_i>=p.length() ||(p_i == p.length()-1 && p.charAt(p_i)=='*');

        //s没匹配完
        switch (p.charAt(p_i)){
            case '?':
                return check(s,s_i+1,p,p_i+1);
            case '*':
                return check(s,s_i,p,p_i+1)|| //* 匹配 空
                        check(s,s_i+1,p,p_i)||  //* 匹配 1+
                        check(s,s_i+1,p,p_i+1); //* 匹配 1
            default:
                if (s.charAt(s_i) == p.charAt(p_i))
                    return check(s,s_i+1,p,p_i+1);
        }
        return false;
    }
    private boolean check(String s,int s_i, String p,int p_i) {
        if (dict[s_i][p_i] == -1)return false;
        if (dict[s_i][p_i] == 1)return true;
        else {
            boolean b = help(s,s_i,p,p_i);
            dict[s_i][p_i] = b?1:-1;
            return b;
        }
    }
}
