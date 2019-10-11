package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1147 {
    @Test
    public void t(){
        System.out.println(longestDecomposition("aaa"));
    }
    int res = 0;
    Map<String,Integer> map = new HashMap<>();
    public int longestDecomposition(String text) {
        if (text.length()==1)return 1;
        if (text.length()==0)return 0;
        for (int i = 0; i < text.length()/2+1; i++) {
            String left = text.substring(0,i+1);
            String right = text.substring(text.length()-i-1);
            if (left.equals(right)){
                int leftRes;
                if (i+1>text.length()-i-1)break;
                String mid = text.substring(i+1,text.length()-i-1);
                if (map.containsKey(mid))leftRes = map.get(mid);
                else {
                    leftRes = longestDecomposition(mid);
                    map.put(mid,leftRes);
                }
                res = Math.max(res,2+leftRes);
            }
        }
        if (res == 0)res=1;
        return res;
    }

}
