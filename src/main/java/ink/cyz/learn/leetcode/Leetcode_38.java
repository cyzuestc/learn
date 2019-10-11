package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_38 {
    @Test
    public void test(){
        long t1 = System.currentTimeMillis();
        System.out.println(countHelp("111123"));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = countHelp(res);
        }
        return res;
    }
    public String countHelp(String string){
        StringBuilder res = new StringBuilder();
        char[] s = string.toCharArray();
        char num = s[0];
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (num != c){
                res.append(count).append(num);
                num = c;
                count = 1;
            }else {
                count++;
            }
        }
        res.append(String.valueOf(count)+String.valueOf(num));
        return res.toString();
    }
}
