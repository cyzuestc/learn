package ink.cyz.learn.leetcode;


public class Leetcode_3 {
    public static void main(String[] args) {
        String s = "tmmzuxt";

        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int[] map = new int[200];
        int i = -1;
        int j = 0;
        while (j<s.length()){
            char cur = s.charAt(j);
            if (map[cur] == 0){
                map[cur] = 1;
                maxLen = Math.max(maxLen,j-i);
                j++;
            }else {
                i++;
                map[s.charAt(i)] = 0;
            }
        }
        return maxLen;
    }
}
