package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 19:30 2019/8/26
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_238 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = res[i]*left;
            res[nums.length-i-1] *= right;
            left = left*nums[i];
            right = right*nums[nums.length-i-1];
        }
        return res;
    }
}
