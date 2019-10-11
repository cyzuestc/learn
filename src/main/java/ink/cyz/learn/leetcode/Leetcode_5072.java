package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Leetcode_5072 {
    @Test
    public void t(){

    }
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 5000;
        for (int i = 0; i < arr.length; i++) {
            if (sum>arr[i])sum-=arr[i];
            else return i;
        }
        return arr.length;
    }

}
