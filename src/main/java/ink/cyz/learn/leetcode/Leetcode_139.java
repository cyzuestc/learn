package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.*;

public class Leetcode_139 {

    @Test
    public void t(){
        List<String> w = new ArrayList<>();
        w.add("cats");
        w.add("dog");
        w.add("sand");
        w.add("and");
        w.add("cat");
        String s = "catsandog";
        System.out.println(wordBreak1(s,w));
    }
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s.isEmpty())return true;
        if (wordDict.isEmpty())return false;
        int maxLen = wordDict.get(0).length();
        int minLen = maxLen;
        Set<String> map = new HashSet<>();
        for (String word : wordDict){
            map.add(word);
            int len = word.length();
            maxLen = Math.max(maxLen,len);
            minLen = Math.min(minLen,len);
        }
        boolean[] dp = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i] = help1(dp,s,map,i,minLen,maxLen);
        }

        Utils.print(dp);

        return dp[dp.length-1];
    }

    //以index结尾
    private boolean help1(boolean[] dp, String s, Set<String> map, int index, int minLen, int maxLen) {
        for (int i = index-maxLen+1; i <=index-minLen+1; i++) {
            if (i <0)continue;
            String word = s.substring(i,index+1);
            System.out.println(word);
            if (map.contains(word)){
                if (i == 0 || dp[i-1] == true)return true;
            }
        }
        return false;
    }
}
