package ink.cyz.learn.leetcode;

import org.junit.Test;

/**
 * @ Author      : Zink
 * @ Date        : Created in 21:19 2019/8/28
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_303 {
    int[] nums ;
    int[] dp;
    public Leetcode_303(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            if (i==0)dp[i]=nums[0];
            else
            dp[i] = nums[i]+dp[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if (i==0)return dp[j];
        return dp[j]-dp[i-1];
    }
}

