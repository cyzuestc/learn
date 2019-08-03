package ink.cyz.learn.leetcode;

import java.util.Arrays;

public class leetcode_1 {

    public int[] twoSum(int[] nums, int target) {
        int[] newNum = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while (i<j){
            if (nums[i]+nums[j]>target){
                j--;
            }else if (nums[i]+nums[j]<target){
                i++;
            }else {
                break;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if (newNum[k] == nums[i]){
                i=k;
                break;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (newNum[k] == nums[j]){
                j=k;
                break;
            }
        }
        return new int[]{i,j};
    }

    public static void main(String[] args) {


    }
}
