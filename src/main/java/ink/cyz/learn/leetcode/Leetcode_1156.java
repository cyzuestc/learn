package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1156 {
    @Test
    public void t(){
        String s = "aabaaabaaaba";
        System.out.println(maxRepOpt1(s));
    }
    
    public int maxRepOpt1(String text) {
        if (text.equals(""))return 0;

        Map<Character,Integer> cMap = new HashMap<>();
        char[] cs = text.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!cMap.containsKey(cs[i]))cMap.put(cs[i],1);
            else cMap.put(cs[i],cMap.get(cs[i])+1);
        }

        char last = cs[0];
        int lastLen = 1;

        char[] newCs = new char[cs.length];
        int[] newCsDup = new int[cs.length];
        int index = 0;

        for (int i = 1; i < cs.length; i++) {
            char c = cs[i];
            if (c == last)lastLen++;
            else {
                newCs[index] = last;
                newCsDup[index] = lastLen;
                last = c;
                lastLen = 1;
                index++;
            }
        }

        newCs[index] = last;
        newCsDup[index] = lastLen;
        index++;

        Utils.print(newCs,index);
        Utils.print(newCsDup);


        int res = 0;
        for (int i = 0; i < index; i++) {
            int a = help(newCs,newCsDup,i,cMap,index);
            if (cMap.get(newCs[i])>a)a++;
            res = Math.max(a,res);
        }
        return res;
    }

    private int help(char[] newCs, int[] newCsDup, int i, Map<Character, Integer> cMap, int index) {
        if (i+2<index){
            if (newCs[i] == newCs[i+2]&&newCsDup[i+1]==1){
                return newCsDup[i]+newCsDup[i+2];
            }
        }
        return newCsDup[i];
    }

}
