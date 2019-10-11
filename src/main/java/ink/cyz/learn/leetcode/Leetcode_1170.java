package ink.cyz.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int len = 0;
        int max = 0;
        int[] map = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            map[i] = f(words[i]);
        }


        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            int cur = f(s);
            for (int j = 0; j < map.length; j++) {
                res[i] += cur < map[j]?1:0;
            }
            len++;
        }

        return Arrays.copyOf(res,len+1);
    }
    public int f(String s){
        if (s.equals(""))return 0;
        char ch = 'z';
        int count = 0;
        char[] cs = s.toCharArray();
        for (char c : cs){
            if (c==ch)count++;
            else if (c < ch){
                ch = c;
                count = 1;
            }
        }
        return count;
    }
}
