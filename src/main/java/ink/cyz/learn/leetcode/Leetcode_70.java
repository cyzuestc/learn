package ink.cyz.learn.leetcode;


public class Leetcode_70 {

    public int climbStairs(int n) {
        if (n==1)return 1;
        if (n==2)return 2;
        int lastLast = 1;
        int last = 2;
        for (int i = 3; i <= n; i++) {
            int temp = lastLast;
            lastLast = last;
            last = temp+lastLast;
        }
        return last;
    }
}
