package ink.cyz.learn.leetcode;

public class Leetcode_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int i = 0;
        int j = nums.length-1;
        while (i<=j){
            int m = (i+j) >>1;
            if (nums[m] > target){
                j = m-1;
            }else if (nums[m] < target){
                i = m+1;
            }else {
                i = m;
                for (int k = m; k >=0; k--) {
                }

                return res;
            }
        }
        return res;
    }


}
