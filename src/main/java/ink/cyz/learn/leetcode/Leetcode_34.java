package ink.cyz.learn.leetcode;

import java.util.Arrays;

public class Leetcode_34 {

    public static void main(String[] args) {
        Leetcode_34 t = new Leetcode_34();
        int[] num = {2,2,2,2,2,2,4};
        t.searchRange(num,2);
    }
    public int[] searchRange(int[] nums, int target) {

        int left = searchLeftRange(nums,target);
        int right = searchRightRange(nums,target);
        System.out.println(left+" "+right);
        if (left == -1){
            return new int[]{-1,-1};
        }
        return new int[]{left,right};

    }
    public int searchLeftRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while (i<=j){
            int m = (i+j+1) >>1;
            if (nums[m] > target){
                j = m-1;
            }else if (nums[m] < target){
                i = m+1;
            }else if (nums[m] == target){
                if (m>0 && nums[m-1] == target){
                    j = m-1;
                }
                else {
                    return m;
                }
            }
        }
        return -1;
    }

    public int searchRightRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        while (i<=j){
            int m = (i+j) >>1;
            if (nums[m] > target){
                j = m-1;
            }else if (nums[m] < target){
                i = m+1;
            }else if (nums[m] == target){
                if (m+1<nums.length && nums[m+1] == target){
                    i = m+1;
                }
                else {
                    return m;
                }
            }
        }
        return -1;
    }

}
