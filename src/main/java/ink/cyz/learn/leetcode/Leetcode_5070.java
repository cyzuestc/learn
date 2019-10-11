package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_5070 {
    @Test
    public void t(){
        int[] c = {1,1,2,1,3,2,2,3,3};
        int[][] q =
        {{1,3},{2,2},{6,1}};

        Utils.print(shortestDistanceColor(c,q));
    }

    public int[] shortestDistanceColor(int[] colors, int[][] queries) {
        StringBuilder sb = new StringBuilder();
        for (int i : colors){
            sb.append(i);
        }
        int[] res = new int[queries.length];
        int resIndex = 0;
        String s = sb.toString();
        String sReverse = sb.reverse().toString();
        for (int[] query:queries){
            int index = query[0];
            char num = (char) (query[1]+'0');

            int right = s.indexOf(num,index)-index;
            int left = sReverse.indexOf(num,s.length()-1-index)-(s.length()-1-index);
            if (left == -1&&right == -1)res[resIndex] = -1;
            else if (left == -1)res[resIndex] = right;
            else if (right == -1)res[resIndex] = left;
            else res[resIndex] = Math.min(left,right);
            resIndex++;
        }
        return res;
    }
}
