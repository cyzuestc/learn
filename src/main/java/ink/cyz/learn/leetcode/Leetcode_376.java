package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_376 {
    @Test
    public void t(){
        System.out.println();
    }
    public int wiggleMaxLength(int[] nums) {
        int res = 1;

        int lastCompare = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i == 1){
                if (nums[i] != nums[i-1])res++;
                lastCompare = nums[1]-nums[0];
                continue;
            }
            if (nums[i] == nums[i-1])continue;
            if (nums[i] > nums[i-1] && lastCompare < 0){
                res++;
            }
            if (nums[i] < nums[i-1] && lastCompare > 0){
                res++;
            }
            lastCompare = nums[1]-nums[0];
        }
        return res;
    }

}
