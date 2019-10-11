package ink.cyz.learn.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      : Zink
 * @ Date        : Created in 16:38 2019/8/25
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_229 {
    public List<Integer> majorityElement(int[] nums) {
        Integer A = null;
        int countA = 0;
        Integer B = null;
        int countB = 0;
        for (int num : nums){
            //A,B初始化
            if (A == null){
                A = num;
                countA++;
                continue;
            }else if (B == null && A != num){
                B = num;
                countB++;
                continue;
            }
            //是A或者B
            if (num == A){
                countA++;
            }else if (num == B){
                countB++;
            }
            //都不是
            else {
                if (countA==0&&countB == 0){
                    A = num;
                    countA++;
                }else if (countA == 0||countB==0){
                    if (countA==0){
                        A = num;
                        countA++;
                    }
                    else if (countB == 0){
                        B = num;
                        countB++;
                    }
                }else {
                    countA--;
                    countB--;
                }

            }

        }

        countA = 0;
        countB = 0;
        for (int num : nums){
            if (A == num)countA++;
            if (B == num)countB++;
        }

        List<Integer> res = new ArrayList<>();
        if (countA*3>nums.length)res.add(A);
        if (countB*3>nums.length)res.add(B);

        return res;
    }
}
