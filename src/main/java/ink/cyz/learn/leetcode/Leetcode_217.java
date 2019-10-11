package ink.cyz.learn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author      : Zink
 * @ Date        : Created in 19:54 2019/8/22
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_217 {

    public boolean containsDuplicate2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]) {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums){
            if (set.contains(n))return true;
            else set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
       int[] a = new int[20000000];
    }
}
