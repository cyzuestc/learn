package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_97 {
    @Test
    public void t(){
        System.out.println(isInterleave("accc","fb","acfcbc"));
    }
   public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() +s2.length() != s3.length())return false;
        if(s1.isEmpty())return s2.equals(s3);
        if (s2.isEmpty())return s1.equals(s3);
       map = new Boolean[s1.length()+1][s2.length()+1];
       return help(s1,0,s2,0,s3);
   }

    Boolean[][] map ;
    private boolean help(String s1, int i1, String s2, int i2, String s3) {
       char c1 = s1.charAt(i1);
       char c2 = s2.charAt(i2);
       char c3 = s3.charAt(i1+i2);

        Boolean b1 = map[i1+1][i2];
        Boolean b2 = map[i1][i2+1];

        if (b1 == null){
            if (c1 == c3){
                if (i1+1 == s1.length()){
                    b1 = s2.substring(i2).equals(s3.substring(i1+i2+1));
                }
                else {
                    b1 = help(s1,i1+1,s2,i2,s3);
                }
            }else {
                b1 = false;
            }
            map[i1+1][i2] = b1;
        }
        if (b1)return true;
        if (b2 == null){
            if (c2 == c3){
                if (i2+1 == s2.length()){
                    b2 = s1.substring(i1).equals(s3.substring(i1+i2+1));
                }else {
                    b2 = help(s1,i1,s2,i2+1,s3);
                }
            }else {
                b2 = false;
            }
            map[i1][i2+1] = b2;
        }
        return b1 || b2;
    }
}
