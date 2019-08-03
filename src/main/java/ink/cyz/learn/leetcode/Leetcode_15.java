package ink.cyz.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_15 {
    public static void main(String[] args) {
        int[] nums= {-1,0,1,2,-1,-4};
        System.out.println(threeSum2(nums));
    }
    public static List<List<Integer>> threeSum2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i>0 && i<nums.length && nums[i] == nums[i-1])i++;
            int pre = i+1;
            int post = nums.length-1;
            while (post>pre){
                int sum = nums[post] + nums[pre] + nums[i];
                if (sum>0){
                    post--;
                }else if (sum<0){
                    pre++;
                }else {
                    res.add(Arrays.asList(nums[i],nums[pre],nums[post]));
                    pre++;
                    post--;
                    while (pre < nums.length-1 && nums[pre] == nums[pre-1])pre++;
                    while (post >= 0 && nums[post] == nums[post+1])post--;
                }
            }

        }

        return res;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (i>0 && i<nums.length && nums[i] == nums[i-1])i++;
            for (int j = nums.length-1; j >i ; j--) {
                while (j<nums.length-1 && j>0 && nums[j] == nums[j+1])j--;

                int left = i+1;
                int right = j-1;
                while (left<=right) {
                    int m = (left + right) / 2;
                    int sum = nums[i] + nums[j] + nums[m];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i],nums[m],nums[j]));
                       break;
                    }else if (sum>0){
                        right = m-1;
                    }else {
                        left = m+1;
                    }
                }

            }
        }


        return res;
    }
}
