package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.*;

public class Leetcode_5068 {
    @Test
    public void t(){
        String[] phrases =
                {"a","b","a"};
//                {"mission statement",
//                "a quick bite to eat",
//                "a chip off the old block",
//                "chocolate bar",
//                "mission impossible",
//                "a man on a mission",
//                "block party",
//                "eat my words",
//                "bar of soap"};
//        Utils.print(beforeAndAfterPuzzles(phrases));
        System.out.println(beforeAndAfterPuzzles(phrases));
    }
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Arrays.sort(phrases);
        List<String> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
            String cur = phrases[i];
            String headLeft = getHead(cur)[0];
            String headRight = getHead(cur)[1];
            headRight+= ","+i;

            if (map.containsKey(headLeft)){
                map.get(headLeft).add(headRight);
            }else {
                List<String> list = new ArrayList<>();
                list.add(headRight);
                map.put(headLeft,list);
            }
        }

        for (int i = 0; i < phrases.length; i++) {
            String cur = phrases[i];
            String tail = getTail(cur);

            if (map.get(tail) != null){
                for (String next : map.get(tail)){
                    String newS ;
                    int id = Integer.parseInt(next.split(",")[1]);
                    next=next.split(",")[0];
                    if (!next.isEmpty())newS = cur+" "+next;
                    else newS = cur;
                    if (!res.contains(newS) && id != i)res.add(newS);
                }
            }
        }



        return res;
    }

    private String[] getHead(String cur) {
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == ' ')return new String[]{cur.substring(0,i),cur.substring(i+1)};
        }
        return new String[]{cur,""};
    }

    private String getTail(String cur) {
        for (int i = cur.length()-1; i >= 0 ; i--) {
            if (cur.charAt(i) == ' ')return cur.substring(i+1);
        }
        return cur;
    }
}
