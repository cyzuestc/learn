package ink.cyz.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_18 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        Leetcode_18 t = new Leetcode_18();
        System.out.println(t.fourSum(nums,target));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            while (i>0 && i<nums.length && nums[i] == nums[i-1])i++;
            if (nums.length-i-1 <3)break;
            int[] newArr = new int[nums.length-i-1];
            for (int j = i+1; j < nums.length; j++) {
                newArr[j-i-1] = nums[j];
            }
            List<List<Integer>> subList = threeSum2(newArr,nums[i],target-nums[i]);
            for (int j = 0; j < subList.size(); j++) {
                res.add(subList.get(j));
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum2(int[] nums,int headnum,int target){
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i>0 && i<nums.length && nums[i] == nums[i-1])i++;
            int pre = i+1;
            int post = nums.length-1;
            while (post>pre){
                int sum = nums[post] + nums[pre] + nums[i]-target;
                if (sum>0){
                    post--;
                }else if (sum<0){
                    pre++;
                }else {
                    res.add(Arrays.asList(headnum,nums[i],nums[pre],nums[post]));
                    post--;
                    pre++;
                    while (pre < nums.length-1 && nums[pre] == nums[pre-1])pre++;
                    while (post >= 0 && nums[post] == nums[post+1])post--;
                }
            }
        }
        return res;
    }
}
