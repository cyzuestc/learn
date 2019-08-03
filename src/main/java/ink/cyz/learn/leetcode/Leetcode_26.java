package ink.cyz.learn.leetcode;

public class Leetcode_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)return 0;
        int len = 1;
        int compareNum = nums[0];
        int i = 1;
        while (i<nums.length){
            while (i<nums.length && nums[i] == compareNum)i++;
            if (i<nums.length){
                nums[len] = nums[i];
                compareNum = nums[len];
                len++;
                i++;
            }
        }
        return len;
    }
}
