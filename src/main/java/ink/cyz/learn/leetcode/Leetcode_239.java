package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 19:30 2019/8/26
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_239 {
    public int[] m(int[] nums,int k){
        int[] res = new int[nums.length-k+1];
        int maxIndex = 0;
        for (int i = 0; i < res.length; i++) {
            if (i == 0)maxIndex = getMax(nums,i,k+i);
            else {
                if (i>maxIndex){
                    maxIndex = getMax(nums,i,k+i);
                }else {
                    if (nums[k+i-1] > nums[maxIndex]){
                        maxIndex = k+i-1;
                    }
                }
            }
            res[i] = nums[maxIndex];
        }
        return res;
    }

    public int getMax(int[] nums,int left,int right){
        int res= left;
        for (int i = left; i < right; i++) {
            if (nums[res]<nums[i]){
                res = i;
            }
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int[] maxOld = new int[k];
        int[] maxNew = new int[k];
        for (int i = 0; i < maxOld.length; i++) {
            maxOld[i] = Integer.MIN_VALUE;
            maxNew[i] = Integer.MIN_VALUE;
        }

        maxOld[0] = nums[k-1];
        for (int i = 1; i < k; i++) {
            maxOld[i] = Math.max(maxOld[i-1],nums[k-1-i]);
        }
        res[0] = maxOld[k-1];

        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < maxOld.length; j++) {
                if (j==0)maxNew[j] = nums[i+k-1];
                else {
                    maxNew[j] = Math.max(maxNew[j-1],maxOld[j-1]);
                }
            }
            res[i] = maxNew[k-1];
            maxOld = maxNew;
            maxNew = new int[k];
        }

        return res;
    }
}
