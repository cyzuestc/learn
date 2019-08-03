package ink.cyz.learn.leetcode.utils;

public class Leetcode_10 {
    public static void main(String[] args) {

        String s = "cacbbacabacacaba";
        String p = "b*c*.*c*c*c*ac";
        System.out.println(new Leetcode_10().isMatch(s, p));

    }


    int count = 0;
    public boolean isMatch(String s, String p,  char next) {
        count++;
        System.out.println(count);
//        System.out.print(s + "   ");
//        System.out.print(p + "   ");
//        System.out.println( next);
        //5,6
        if (s.isEmpty()) {
            if (p.isEmpty()) {
                return true;
            } else if (next == '*') {
                return isMatch(s, p.substring(2),  p.length()>3?p.charAt(3):'0');
            }
            return false;
        }
        if (p.isEmpty()) return false;
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s, p.substring(2),  p.length() > 3 ? p.charAt(3) : '0') || isMatch(s.substring(1), p,  next);
            } else {
                return isMatch(s, p.substring(2),  p.length() > 3 ? p.charAt(3) : '0');
            }
        } else if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            return isMatch(s.substring(1), p.substring(1),  getNext(p));
        }
        return false;
    }

    private char getNext(String p) {
        if (p.length() < 3) return '0';
        return p.charAt(2);
    }

    public boolean isMatch(String s, String p) {
        char next = '0';
        if (p.length() > 1) next = p.charAt(1);
        return isMatch(s, p,  next);
    }
}
