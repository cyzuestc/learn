package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ Author      : Zink
 * @ Date        : Created in 23:02 2019/8/10
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_56 {
    @Test
    public void t(){
        int[][] i ={{1,3}};
        Utils.print(merge(i));
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int cur = 0;
        for (int i = 1; i < intervals.length; i++) {
            //没有重叠
            if (res[cur][1] < intervals[i][0]){
                cur++;
                res[cur] = intervals[i];
                //首尾重叠
            }else {
                res[cur][1] = Math.max(intervals[i][1],res[cur][1]);
            }
        }
        return Arrays.copyOf(res,cur+1);
    }
    

}
