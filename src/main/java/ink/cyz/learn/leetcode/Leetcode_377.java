package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_377 {
    @Test
    public void t(){
        int[] n = {1,2,3};
        int t = 4;
        System.out.println(combinationSum4(n,t));
    }
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        int[][] dp = new int[target+1][nums.length+1];

        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
                dp[i][0] = 1;
//            }
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                dp[i][j+1] = help(nums,dp,i,j+1);
            }
        }

        Utils.print(dp);
        return res;
    }

    //前index个数字 和为target  组合的个数
    private int help(int[] nums, int[][] dp, int target, int index) {
        int count = dp[target][index-1];
        while (target-nums[index-1] >=0) {
            count += dp[target-nums[index-1]][index-1];
            target -= nums[index-1];
        }
        return count;
    }



}
