package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_1144 {
    @Test
    public void t(){
        int[] t = {9,6,1,6,2};
        System.out.println(movesToMakeZigzag(t));
    }
    public int movesToMakeZigzag(int[] nums) {
        int res = h1(nums);
        res = Math.min(res,h2(nums));
        return res;
    }
//    小大小大小
    private int h2(int[] nums) {
        int count=0;int i;
        for (i=0; i <nums.length ; i+=2) {
            int cur = nums[i];
            if (i>=1&&cur>=nums[i-1])cur = nums[i-1]-1;
            if (i+1<nums.length&&cur>=nums[i+1])cur = nums[i+1]-1;
            count+=(nums[i]-cur);
        }
        return count;
    }

    //    大小大小
    private int h1(int[] nums) {
        int count=0;int i;
        for (i=1; i <nums.length ; i+=2) {
            int cur = nums[i];
            if (i>=1&&cur>=nums[i-1])cur = nums[i-1]-1;
            if (i+1<nums.length&&cur>=nums[i+1])cur = nums[i+1]-1;
            count+=(nums[i]-cur);
        }
        return count;
    }

}
