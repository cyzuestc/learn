package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Leetcode_416_2 {
    @Test
    public void t(){
//        int[] num = {28,63,95,30,39,16,36,44,37,100,61,73,32,71,100,2,37,60,23,71,53,70,69,82,97,43,16,33,29,5,97,32,29,78,93,59,37,88,89,79,75,9,74,32,81,12,34,13,16,15,16,40,90,70,17,78,54,81,18,92,75,74,59,18,66,62,55,19,2,67,30,25,64,84,25,76,98,59,74,87,5,93,97,68,20,58,55,73,74,97,49,71,42,26,8,87,99,1,16,79};
        int[] num = {1,1};
        System.out.println(canPartition(num));
    }
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total %2==1)return false;
        int half = total/2;
        Arrays.sort(nums);
        return dfs(nums,nums.length-1,half);
    }

    private boolean dfs(int[] nums, int i, int sum) {
        if (i<0||sum<0)return false;
        if (sum==0)return true;
        return dfs(nums,i-1,sum-nums[i])||
                dfs(nums,i-1,sum);
    }

}