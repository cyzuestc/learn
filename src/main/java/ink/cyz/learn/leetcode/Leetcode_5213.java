package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_5213 {
    @Test
    public void t(){
    }
    public int minCostToMoveChips(int[] chips) {
        int even = 0;
        int odd = 0;

        for (int i = 0; i < chips.length; i++) {
            if (chips[i]%2==0)even += 1;
            else odd += 1;
        }
        return Math.min(even,odd);
    }
}
