package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.Arrays;

public class Leetcode_377_2 {
    @Test
    public void t(){
        int[] n = {1,2,3};
        int t = 4;
        System.out.println(combinationSum4(n,t));
    }
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        help(nums,target,0);
        return res;
    }

    private void help(int[] nums, int target, int i) {
        if (target == 0){
            res++;
            return;
        }
        if (target<0)return;

        if (i>nums.length-1)return;

        for (int j = i; j < nums.length; j++) {
            help(nums,target-nums[j],j);
            help(nums,target,j+1);
        }
    }


}
