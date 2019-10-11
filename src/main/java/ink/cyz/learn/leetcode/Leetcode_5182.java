package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_5182 {
    @Test
    public void t(){
        int[] a = {-17,10,-7,-4,11,-2,-11,8,-17,-14,17,-20,19,6,13,-8,7,-6,-7,12};
        int[] t = {11,-10,-11,8,7,-6,9,4,11,6,5,0};
        System.out.println(maximumSum(a));
    }
    public int maximumSum(int[] arr) {
        if (arr.length == 0)return 0;
        if (arr.length == 1)return arr[0];

        int sum = 0;
        int res = 0;
        int maxNum = arr[0];

        boolean used = false;
        int useNum = 0;
        int sumRegular = 0;

        for (int i = 0; i < arr.length; i++) {
            maxNum = Math.max(maxNum,arr[i]);

            int cur = arr[i];

            if (cur>=0){
                sum += cur;
                res = Math.max(res,sum);
            }else {
                if (sum+cur>0){
                    sum+=cur;
                    if (!used){
                        sum-=cur;
                        used = true;
                        useNum = cur;
                    }
                    else if (cur<useNum){
                        sum+=useNum;
                        sum-=cur;
                        used = true;
                        useNum = cur;
                    }
                }else {
                    if (sum+useNum>0){
                        used = true;
                        sum = sum+useNum;
                        useNum = cur;
                    }else {
                        used = false;
                        sum = 0;
                    }
                }
                if (sumRegular > sum){
                    sum = sumRegular;
                    used = true;
                    useNum = cur;
                }
            }

            if (sumRegular+cur>0)sumRegular+= cur;
            else sumRegular = 0;
//            System.out.println(cur+"  "+sum+" "+used+" "+useNum+" "+sumRegular);
        }
        if (maxNum<=0)return maxNum;
        return res;
    }
}
