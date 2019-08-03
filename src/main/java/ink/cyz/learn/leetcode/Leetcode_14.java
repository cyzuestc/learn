package ink.cyz.learn.leetcode;

public class Leetcode_14 {
    public static void main(String[] args) {

    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null||strs.length == 0)return "";
        StringBuilder sb = new StringBuilder();
        char cur = ' ';
        for (int i = 0; i < strs[0].length(); i++) {
            cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length()<= i ||strs[j].charAt(i) != cur)return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}
