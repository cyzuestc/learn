package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_41 {
    @Test
    public void t(){
        int[] n = {3,4,-1,1};
        System.out.println(firstMissingPositive(n));
    }
    public int firstMissingPositive(int[] nums) {
        int max = nums.length;

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >0 && nums[i] <= max && nums[nums[i]-1] != nums[i]){
                    int num = nums[i]-1;
                    nums[num] =nums[num] ^ nums[i] ^ (nums[i] = nums[num]);
                }
            }
        }
        Utils.print(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)return i+1;
        }

        return 0;
    }
}
