package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 22:48 2019/8/10
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)return 0;
        int max = nums[0];
        int cur = nums[0]>0?nums[0]:0;
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n+cur >= 0){
                cur+= n;
                max = Math.max(max,cur);
            }else {
                cur = 0;
                max = Math.max(max,n);
            }
        }
        return max;
    }
}
