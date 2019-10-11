package ink.cyz.learn.leetcode;

import java.util.List;

public class Leetcode_120_2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = triangle.size()-1;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == dp.length -1){
                    dp[i] = list.get(j);
                }else {
                    dp[i] = list.get(j) + Math.min(dp[j],dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}
