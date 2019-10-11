package ink.cyz.learn.leetcode;

public class Leetcode_35 {
     public int searchInsert(int[] nums, int target) {
         if (nums.length == 0||target <= nums[0])return 0;
         if (target>nums[nums.length-1])return nums.length;
         int i = 0;
         int j = nums.length-1;
         int m = 0;
         while (i<=j){
            m = (i+j+1) >>1;
            if (nums[m] > target){
                j = m-1;
            }else if (nums[m] < target){
                i = m+1;
            }else if (nums[m] == target){
                return m;
            }
        }
         if (nums[m] < target)return m+1;
         else  return m;
    }
}
