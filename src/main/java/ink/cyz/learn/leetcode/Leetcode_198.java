package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 21:14 2019/8/21
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_198 {
    public int rob(int[] nums) {
        if (nums.length==0)return 0;
        if (nums.length==1)return nums[0];
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i==0)dp[i] = nums[0];
            else if (i == 1)dp[i] = nums[1];
            else if (i == 2)dp[i] = nums[0]+nums[2];
            else {
                dp[i] = nums[i] + Math.max(dp[i-2],dp[i-3]);
            }
        }

        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }
}
