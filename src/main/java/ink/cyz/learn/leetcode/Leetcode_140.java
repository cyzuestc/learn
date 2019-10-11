package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.*;

public class Leetcode_140 {

    @Test
    public void t(){
        List<String> w = new ArrayList<>();
        w.add("cats");
        w.add("og");
        w.add("san");
        w.add("and");
        w.add("cat");
        String s = "catsandog";
        System.out.println(wordBreak(s,w));
    }
    HashMap<Integer,List<String>> mapList = new HashMap();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> iniList = new ArrayList<>();
        iniList.add("");
        mapList.put(-1,iniList);

        if (s.isEmpty())return mapList.get(-1);
        if (wordDict.isEmpty())return mapList.get(-1);


        int maxLen = wordDict.get(0).length();
        int minLen = maxLen;
        Set<String> map = new HashSet<>();
        for (String word : wordDict){
            int len = word.length();
            map.add(word);
            maxLen = Math.max(maxLen,len);
            minLen = Math.min(minLen,len);
        }
        boolean[] dp = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i] = help(dp,s,map,i,minLen,maxLen);
        }

        List<String> res = mapList.get(s.length()-1);
        return res == null?new ArrayList<>():res;
    }

    //以index结尾
    private boolean help(boolean[] dp, String s, Set<String> map, int index, int minLen, int maxLen) {
        boolean isOk = false;
        for (int i = index-maxLen+1; i <=index-minLen+1; i++) {
            if (i <0)continue;
            String word = s.substring(i,index+1);
            if (map.contains(word)){
                if (i == 0 || dp[i-1]){
                    List<String> temp = mapList.get(i-1);
                    if (temp == null)temp = new ArrayList<>();

                    List<String> cur = mapList.get(index);
                    if (cur == null)cur = new ArrayList<>();

                    for (String tempS : temp){
                        if (tempS.isEmpty())cur.add(word);
                        else cur.add(tempS+" "+word);
                    }
                    mapList.put(index,cur);
                    isOk = true;
                }
            }
        }
        return isOk;
    }
}
