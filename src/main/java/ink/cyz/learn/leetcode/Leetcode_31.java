package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;

public class Leetcode_31 {
    public static void main(String[] args) {
        Leetcode_31 t = new Leetcode_31();
        int[] arr = new int[]{5,4,7,5,3,2};
        t.nextPermutation(arr);
        Utils.print(arr);

    }
    public void nextPermutation(int[] nums) {
        boolean isDesc = true;
        for (int i = nums.length-1; i > 0; i-- ) {
            if (nums[i] > nums[i-1]){
                for (int j = nums.length-1; j >0 ; j--) {
                    if (nums[j] > nums[i-1]){
                        swapHelp(nums,i-1,j);
                        Utils.print(nums);
                        evit(nums,i,nums.length-1);
                        return;
                    }
                }
            }
        }
        evit(nums,0,nums.length-1);
    }
    private void evit(int[] nums, int i, int j) {
        while (i<j){
            swapHelp(nums,i++,j--);
        }
    }
    private void swapHelp(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j] ^ (nums[j] = nums[i]);
    }
}
