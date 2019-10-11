package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Leetcode_354 {
    @Test
    public void t(){

        int[][] e = {{1,3},{3,5},{6,7},{8,4},{6,8},{9,5}};
        maxEnvelopes(e);
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])return o2[1]-o1[1];
                return o1[0]-o2[0];
            }
        });

        Stack<int[]>[] dp = new Stack[envelopes.length];
        int len = 0;

        for (int i = 0; i < envelopes.length; i++) {
            if (len == 0){
                dp[len] = new Stack<int[]>();
                dp[len].push(envelopes[i]);
                len++;
                continue;
            }
            int h1 = dp[len-1].peek()[1];
            int h2 = envelopes[i][1];

            if (h1 < h2){
                dp[len] = new Stack();
                dp[len].push(envelopes[i]);
                len++;
            }
            else if (h1 > h2){
                swap(dp,len,envelopes[i]);
            }
        }


        int res = 0;
//        for (int i = 0; i < len-1; i++) {
//            if (dp[i].peek()[0] == dp[i+1].peek()[0]){
//                dp[i].pop();
//            }
//        }
        for (int i = 0; i < len; i++) {
            if (dp[i].isEmpty())continue;
            res++;
        }
//        Utils.print(dp);

        System.out.println(len);
        System.out.println(res);
        return res;
    }

    private void swap(Stack<int[]>[] dp, int len, int[] envelope) {
        int w2 = envelope[0];
        int h2 = envelope[1];
        for (int i = 0; i <len ; i++) {
            int h1 = dp[i].peek()[1];

//            if (h1 == h2)
            if (h1 >= h2){
                dp[i].push(envelope);
                break;
            }
        }
    }
}
