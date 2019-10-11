package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.*;

public class Leetcode_5199 {
    @Test
    public void t(){
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(0);
        list3.add(2);
        pairs.add(list1);
        pairs.add(list2);
        pairs.add(list3);
        System.out.println(smallestStringWithSwaps(s,pairs));
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] c = s.toCharArray();
        int count = 0;
        while (count < pairs.size()){
        count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < pairs.size(); i++) {
            int a = pairs.get(i).get(0);
            int b = pairs.get(i).get(1);
            if (a==-1){
                count++;
                continue;
            }

            if (set.isEmpty()||set.contains(a)||set.contains(b)){
                if (!set.contains(a)){
                    set.add(a);
                }
                if (!set.contains(b)){
                    set.add(b);
                }
                pairs.get(i).set(0,-1);
            }
        }
        help(set,c,s);

        }
        StringBuilder sb = new StringBuilder();
        for (char ch : c){
            sb.append(ch);
        }
        return sb.toString();
    }

    private void help(Set<Integer> set, char[] c, String s) {
//        System.out.println(set);
        char[] sets = new char[set.size()];
        int[] indexArr = new int[set.size()];
        int index = 0;
        for (int i:set){
            sets[index] = s.charAt(i);
            indexArr[index] = i;
            index++;
        }
        Arrays.sort(sets);
        Arrays.sort(indexArr);
        for (int i = 0; i < indexArr.length; i++) {
            c[indexArr[i]] = sets[i];
        }
    }
}
