package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1163 {
    @Test
    public void t(){
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(lastSubstring(s));
    }

    public String lastSubstring(String s) {
        char maxC = 'a';
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            maxC = c>maxC?c:maxC;
        }
        List<Integer> list = new ArrayList<>();
        boolean lastCIsMaxC = false;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == maxC){
                if (!lastCIsMaxC){
                    list.add(i);
                }
                lastCIsMaxC = true;
            }else {
                lastCIsMaxC = false;
            }
        }

        int len = 1;
        while (list.size()>1){
            System.out.println(list);
            list = help(cs,len,list);
            len++;
        }
        int start = list.get(0);
        return s.substring(start,s.length());
    }

    private List<Integer> help(char[] cs, int len, List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        char maxC = '0';
        for (int index : list){
            if (index+len>cs.length-1)continue;
            char c = cs[index+len];
            maxC = (c>maxC?c:maxC);
        }
        for (int index : list){
            if (index+len>cs.length-1)continue;
            if (cs[index+len] == maxC){

                res.add(index);
            }
        }
        return res;
    }

}
