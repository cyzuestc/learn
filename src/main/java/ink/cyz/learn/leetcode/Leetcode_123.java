package ink.cyz.learn.leetcode;

public class Leetcode_123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)return 0;
        int buy1 = prices[0];
        int sell1 = 0;
        int buy2 = buy1;
        int sell2 = 0;
        for (int p : prices){
            buy1 = Math.min(buy1,p);
            sell1 = Math.max(sell1,p - buy1);
            buy2 = Math.min(buy2,p - sell1);
            sell2 = Math.max(sell2,p-buy2);
        }
        return sell2;
    }
}
