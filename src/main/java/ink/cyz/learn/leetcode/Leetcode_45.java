package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_45 {
    @Test
    public void t(){
        int[] nums = {1};
        System.out.println(jump(nums));
    }
    public int jump(int[] nums) {
        if (nums.length <2||nums[0] == 0)return 0;
        int curStep = 0;
        int curMaxStep = nums[0];
        int nextMaxStep = Integer.MIN_VALUE;
        int i = 0,j ;
        while (i<nums.length) {

            for (j = i+1; j <= curMaxStep; j++) {
                if (j >= nums.length-1)return curStep+1;
                nextMaxStep = Math.max(nextMaxStep,j+nums[j]);
            }

            i = curMaxStep;
            curMaxStep = nextMaxStep;
            curStep++;
        }
        return 0;
    }
}
