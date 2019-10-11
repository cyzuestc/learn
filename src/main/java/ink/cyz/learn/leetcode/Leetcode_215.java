package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 19:09 2019/8/22
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,k,0,nums.length-1);
    }

    public int findKthLargest(int[] nums, int k,int left,int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i<j){
            while (i<j && nums[j]>= pivot){
                j--;
            }
            swap(nums,i,j);
            while (i<j && nums[i] <= pivot){
                i++;
            }
            swap(nums,i,j);
        }
        if (right -i+1 == k )return nums[i];
        else if (right-i+1 > k)return findKthLargest(nums,k,i+1,right);
        else return findKthLargest(nums,k-(right-i+1),left,i-1);
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j] ^ (nums[j]=nums[i]);
    }
}
