package ink.cyz.learn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode_30 {
    public static void main(String[] args) {
        Leetcode_30 t = new Leetcode_30();
        System.out.println(t.findSubstring("ababaabab",new String[]{"ab","ba"}));
    }
    List<Integer> res = new ArrayList<>();
    HashMap<String,Integer> dict = new HashMap<>();
    HashMap<String,Integer> tempDict = new HashMap<>();
    int wordLen ;
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0 || s.length() == 0)return res;
        wordLen = words[0].length();
        buildDict(words);
        for (int i = 0; i < wordLen; i++) {
            findSubstringHelp(s.substring(i),words,i);
        }
        return res;
    }

    private void findSubstringHelp(String s, String[] words, int position) {
        buildTempDict(words);
        int leftStart = -1;
        int count = 0;
        for (int i = 0; i+wordLen <= s.length(); i+= wordLen) {
            String curStr = s.substring(i,i+wordLen);
            //leftStart的初始化
            if (leftStart == -1 && dict.containsKey(curStr))leftStart = i;
            //出现非字典str,前功尽弃
            if (!dict.containsKey(curStr)){
                buildTempDict(words);
                count = 0;
                leftStart = -1;
            }else {
                int standardThisStrNum = dict.get(curStr);
                if (tempDict.get(curStr)==null)tempDict.put(curStr,0);
                int curThisStrNum = tempDict.get(curStr);
                //tempDict还没填满
                if (curThisStrNum < standardThisStrNum){
                    tempDict.put(curStr,curThisStrNum+1);
                    count++;
                //tempDict已经填满了,需要leftStart前进
                }else {
                    while (!s.substring(leftStart,leftStart+wordLen).equals(curStr)){
                        String leftStartStr = s.substring(leftStart,leftStart+wordLen);
                        tempDict.put(leftStartStr,tempDict.get(leftStartStr)-1);
                        count--;
                        leftStart+= wordLen;
                    }
                    leftStart+= wordLen;
                }
                if (count == words.length)res.add(position+leftStart);
            }
        }

    }

    private void  buildTempDict(String[] words) {
        if (!tempDict.isEmpty())tempDict.clear();
        for (int i = 0; i < words.length; i++) {
             tempDict.put(words[i],0);
        }
    }


    private void buildDict(String[] words) {
        if (!dict.isEmpty())dict.clear();
        for (int i = 0; i < words.length; i++) {
            if (dict.containsKey(words[i]))dict.put(words[i],dict.get(words[i])+1);
            else dict.put(words[i],1);
        }
    }





}
