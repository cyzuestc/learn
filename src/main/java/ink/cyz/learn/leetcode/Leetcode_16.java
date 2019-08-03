package ink.cyz.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_16 {

    public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = Integer.MAX_VALUE;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                while (i>0 && i<nums.length && nums[i] == nums[i-1])i++;
                int pre = i+1;
                int post = nums.length-1;
                while (post>pre){
                    int sum = nums[post] + nums[pre] + nums[i]-target;
                    if (sum>0){
                        if (sum<minDistance){
                            minDistance = sum;
                            res = sum+target;
                        }
                        post--;
                    }else if (sum<0){
                        if (-1* sum<minDistance){
                            minDistance = -1*sum;
                            res = sum+target;
                        }
                        pre++;
                    }else {
                        return target;
                    }
                }

            }
        return res;
    }
}
