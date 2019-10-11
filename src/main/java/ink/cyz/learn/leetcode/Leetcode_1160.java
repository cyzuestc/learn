package ink.cyz.learn.leetcode;

import java.util.Arrays;

public class Leetcode_1160 {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] map = new int[26];
        int[] cur = new int[26];
        generateArr(chars,map);
        for (String s:words){
            generateArr(s,cur);
            boolean isOK = true;
            for (int i = 0; i < map.length; i++) {
                if (cur[i] > map[i]){
                    isOK = false;
                    break;
                }
            }
            if (isOK)res+= s.length();
        }
        return res;
    }

    private void generateArr(String chars, int[] map) {
        Arrays.fill(map,0);
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            map[c-'a'] ++;
        }
    }
}
