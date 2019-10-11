package ink.cyz.learn.leetcode;

public class Leetcode_121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int a = prices[i];
            max = Math.max(max,a-min);
            min = Math.min(min,a);
        }
        return max;
    }
}
