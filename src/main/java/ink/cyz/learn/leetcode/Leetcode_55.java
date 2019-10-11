package ink.cyz.learn.leetcode;

import com.sun.org.apache.bcel.internal.generic.I2F;

/**
 * @ Author      : Zink
 * @ Date        : Created in 22:56 2019/8/10
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 0)return true;
        if (nums[0] <= 0)return false;
        int curStep = 0;
        int curMaxStep = nums[0];
        int nextMaxStep = Integer.MIN_VALUE;
        int i = 0,j ;
        while (i<nums.length) {

            for (j = i+1; j <= curMaxStep; j++) {
                if (j >= nums.length-1)return true;
                nextMaxStep = Math.max(nextMaxStep,j+nums[j]);
            }
            if (i == curMaxStep)return false;
            i = curMaxStep;
            curMaxStep = nextMaxStep;
            curStep++;
        }
        return true;
    }
}
