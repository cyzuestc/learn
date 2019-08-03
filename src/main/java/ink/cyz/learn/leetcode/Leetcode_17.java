package ink.cyz.learn.leetcode;

import java.util.*;

public class Leetcode_17 {

    public static void main(String[] args) {
        String digits = "223455552345555345555";
        Leetcode_17 t = new Leetcode_17();
        System.out.println(t.letterCombinations(digits));
    }
    char[][] keyMap =   {{'a','b','c'},{'d','e','f'},
                        {'g','h','i'},{'j','k','l'},{'m','n','o'},
                        {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    Map<String,List<String>> recordMap = new HashMap();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)return new ArrayList<>(Arrays.asList(""));
        if (digits.length() == 1) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < keyMap[digits.charAt(0)-'2'].length; i++) {
                list.add(keyMap[digits.charAt(0)-'2'][i]+"");
            }
            return list;
        }
        if (recordMap.get(digits)==null){
            char cur = digits.charAt(0);
            List<String> list = new ArrayList();
            for (int i = 0; i < keyMap[cur-'2'].length; i++) {
                List<String> before = letterCombinations(digits.substring(1));
                for (int j = 0; j < before.size(); j++) {
                    list.add(keyMap[cur-'2'][i]+before.get(j));
                }
            }
            recordMap.put(digits,list);
        }
        return recordMap.get(digits);

    }
}
