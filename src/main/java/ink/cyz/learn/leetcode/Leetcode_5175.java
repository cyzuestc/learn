package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.*;

public class Leetcode_5175 {
    @Test
    public void t(){
        int[][] q = {{3,3,0},{1,2,0},{1,3,3},{0,3,1}};
        System.out.println(canMakePaliQueries("hunu",q));
    }

     Map<String,Integer> map = new HashMap<>();
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries){
            res.add(help(s,query));
        }
        return res;
    }

    private Boolean help(String s, int[] query) {
        int len = query[1]-query[0]+1;
        if (query[2] >= len/2)return true;
        int k = query[2];
        if (map.containsKey(query[0]+","+query[1])){
            int num = map.get(query[0]+","+query[1]);
            if (k >= num/2)return true;
            return false;
        }


        Set<Character> set = new HashSet<>();
        for(int i = query[0]; i <= query[1]; i++){
            char c = s.charAt(i);
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        map.put(query[0]+","+query[1],set.size());
        if (k >= set.size()/2)return true;
        return false;
    }
}
