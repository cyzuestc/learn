package ink.cyz.learn.leetcode;

public class Leetcode_27 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                if (i != j)
                    nums[j++] = nums[i];
                else
                    j++;
            }
        }
        return j;
    }
}
