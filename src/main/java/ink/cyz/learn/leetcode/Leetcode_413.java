package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_413 {
    @Test
    public void t(){
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,5,6}));
    }
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer,Integer>[] maps = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            Map<Integer,Integer> curMap = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int interval = A[i]-A[j];
                Map<Integer,Integer> map = maps[j];
                if (map!=null && map.containsKey(interval)){
                    int successive = map.get(interval)+1;
                    curMap.put(interval,successive);
                    res += successive-2;
                }else {
                    curMap.put(interval,2);
                }
            }
            System.out.println(curMap);
            maps[i] = curMap;
        }
        return res;
    }
}
