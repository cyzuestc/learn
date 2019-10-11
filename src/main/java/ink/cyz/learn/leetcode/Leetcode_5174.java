package ink.cyz.learn.leetcode;

public class Leetcode_5174 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        int[] dp = new int[calories.length];

        for (int i = 0; i < k; i++) {
            dp[k-1] += calories[i];
        }

        sum += getScore(dp[k-1],lower,upper);

        for (int i = k; i < calories.length; i++) {
            dp[i] = dp[i-1] + calories[i] - calories[i-k];
            sum += getScore(dp[i],upper,lower);
        }
        return sum;
    }

    private int getScore(int i, int lower, int upper) {
        if (i<lower)return -1;
        if (i>upper)return 1;
        return 0;
    }
}
