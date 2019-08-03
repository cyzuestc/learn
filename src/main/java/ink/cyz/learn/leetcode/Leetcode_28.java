package ink.cyz.learn.leetcode;

public class Leetcode_28 {
    public static void main(String[] args) {
        Leetcode_28 t = new Leetcode_28();
        String haystack = "ll";
        String needle = "ll";
        System.out.println(t.strStr(haystack,needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)return 0;
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            boolean isOk = true;
            for (int j = i; j < needle.length()+i; j++) {
                if (j>= haystack.length() || j-i>= needle.length() || haystack.charAt(j) != needle.charAt(j-i)){
                    isOk = false;
                    break;
                }
            }
            if (isOk)return i;
        }
        return -1;
    }
}
