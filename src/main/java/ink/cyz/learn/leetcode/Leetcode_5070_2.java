package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_5070_2 {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] dp = new int[colors.length+1][3];

        dp[0][0] = -1;
        dp[0][1] = -1;
        dp[0][2] = -1;

        for (int i = 1; i < colors.length; i++) {
            int c = colors[i];
            for (int j = 0; j < 3; j++) {
                if (j+1 == c)dp[i][j] = 0;
                else dp[i][j] = (dp[i-1][j] == -1?-1:dp[i-1][j]+1);
            }
        }

        for (int i = colors.length-2; i >= 0;i--) {
            int c = colors[i];
            for (int j = 0; j < 3; j++) {
                if (j+1 == c){
                    dp[i][j] = 0;
                    continue;
                }
                int right = (dp[i+1][j] == -1?-1:dp[i+1][j]+1);
                if (right == -1)continue;
                if (dp[i][j] == -1)dp[i][j] = right;
                else dp[i][j] = Math.min(dp[i][j],right);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0;i<queries.length;i++){
            int[] query = queries[i];
            int index = query[0];
            int num = query[1];
            res.add(dp[index][num-1]);
        }

        return res;
    }
}
