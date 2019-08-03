package ink.cyz.learn.leetcode;

public class Leetcode_32 {
    public static void main(String[] args) {

        Leetcode_32 t = new Leetcode_32();
        System.out.println(t.longestValidParentheses("()"));
    }
    public int longestValidParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == '(')sb.append(')');
            else sb.append('(');
        }
        System.out.println(s);
        System.out.println(sb.toString());
        return Math.max(longestValidParenthesesHelper(s),longestValidParenthesesHelper(sb.toString()));
    }
     public int longestValidParenthesesHelper(String s) {
        int flag = 0;
        int curLen = 0;
        int maxLen = 0;
         for (int i = 0; i < s.length(); i++) {
             // ( +  ) -
             char c = s.charAt(i);
             if (c == '('){
                 flag++;
                 curLen++;
             } else {
               if (flag == 0){
                    curLen = 0;
               }else {
                   curLen++;
                   flag--;
                   if (flag == 0){
                       maxLen = Math.max(maxLen,curLen);
                   }
               }
             }
         }

        return maxLen;
    }
}
