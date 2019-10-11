package ink.cyz.learn.leetcode;

public class Leetcode_50 {
    public double myPow(double x, int n) {
        if (n==Integer.MIN_VALUE && x>1)return 0.0;
        if (x == 0.0)return 0;
        if (n == 0)return 1;
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        if (n == 1 )return x;
        if (n%2==0){
            double res = myPow(x,n/2);
            return res*res;
        }else {
            double res = myPow(x,n/2);
            return res*res*x;
        }
    }

}
