package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ Author      : Zink
 * @ Date        : Created in 21:19 2019/8/28
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)return 0;
        int[] dp = new int[nums.length];
        int len = 0;
        for (int n : nums){
            int i = Arrays.binarySearch(dp,0,len,n);
            if (i<0){
                i = 0;
            }
            dp[i] = n;
            if (i == len)len++;
        }
        return len;
    }
}
