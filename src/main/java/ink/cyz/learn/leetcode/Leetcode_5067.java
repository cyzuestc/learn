package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_5067 {
    @Test
    public void t(){
        int a = countLetters("aaaaaaaaaa");
        System.out.println(a);
    }

    public int countLetters(String S) {
        if (S.length() == 0)return 0;
        int res = 0;
        int len = 1;
        char last = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == last)len++;
            else {
                res += len*(len+1)/2;
                len = 1;
                last = c;
            }
        }
        res += len*(len+1)/2;
        return res;
    }
}
