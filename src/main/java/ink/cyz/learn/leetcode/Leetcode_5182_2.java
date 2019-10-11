package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_5182_2 {
    @Test
    public void t(){
        int[] arr ={1,-2,0,3};
        System.out.println(maximumSum(arr));
    }
    public int maximumSum(int[] arr) {

        int res = help(arr,-1);
        int maxNum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            maxNum = Math.max(maxNum,arr[i]);
            if (arr[i] < 0){
                int minIndex = i;
                int j = i+1;
                for (; j < arr.length && arr[j]<0; j++) {
                    minIndex = (arr[j]<arr[minIndex])?j:minIndex;
                }
                res = Math.max(help(arr,minIndex),res);
                i = j;
            }
        }
        if (res == 0)return maxNum;
        return res;
    }

    private int help(int[] arr,int skip) {
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (i == skip)continue;
            int cur = arr[i];
            if (sum+cur>0){
                sum += cur;
            }else {
                sum = 0;
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
