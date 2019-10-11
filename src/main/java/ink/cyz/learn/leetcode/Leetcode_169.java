package ink.cyz.learn.leetcode;

import java.util.List;

/**
 * @ Author      : Zink
 * @ Date        : Created in 16:38 2019/8/25
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_169 {
    public int majorityElement(int[] nums) {
        int A = nums[0];
        int count = 0;
        for (int n:nums){
            if (A == n)count++;
            else {
                if (count>0)count--;
                else {
                    A = n;
                    count++;
                }
            }
        }
        return A;
    }
}
