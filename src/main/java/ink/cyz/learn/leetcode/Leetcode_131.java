package ink.cyz.learn.leetcode;

import java.util.*;

public class Leetcode_131 {
    public static void main(String[] args) {
        Leetcode_131 t = new Leetcode_131();
        String s = "aaab";
        System.out.println(t.partition(s));;
    }
    List<List<String>> res= new ArrayList<>();
    List<String> preList = new ArrayList<>();
    Map<String,List<List<String>>> dict = new HashMap<>();

    public List<List<String>> partition(String s) {
        for (int i = 0; i < s.length(); i++) {
            String subS = s.substring(s.length()-i-1);
            res.clear();
            dp(subS);
            dict.put(subS,new ArrayList<>(res));
            System.out.println("dict: "+dict);
        }
        return res;
    }

    public  void dp(String s) {
        if (s.isEmpty())res.add(new ArrayList<>(preList));
        for (int i = 0; i < s.length(); i++) {
            String preS = s.substring(0,i+1);
            String postS = s.substring(i+1);
            if (isB(preS)){
                preList.add(preS);
                List<List<String>> recordList = dict.get(postS);
                if ( recordList!= null){
                    for (List<String> eachList : recordList){
                        List<String> cur = new ArrayList<>(preList);
                        cur.addAll(eachList);
                        res.add(cur);
                    }
                }else {
                    dp(postS);
                }
                preList.remove(preList.size() - 1);
            }
        }
    }

    boolean isB(String s){
        if (s.isEmpty())return true;
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
}
