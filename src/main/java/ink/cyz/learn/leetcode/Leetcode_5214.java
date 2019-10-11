package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Leetcode_5214 {
    @Test
    public void t(){
    }
    public int longestSubsequence(int[] arr, int difference) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr){
            set.add(a);
        }
        if (arr.length ==0)return 0;
        int res = 1;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            int base = arr[i];
            cur = 1;
            if (!set.contains(base+difference))continue;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == base+difference){
                    base += difference;
                    cur ++;
                    res = Math.max(res,cur);
                }
            }
        }
        return res;
    }
}
