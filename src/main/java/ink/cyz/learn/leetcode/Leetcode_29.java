package ink.cyz.learn.leetcode;

public class Leetcode_29 {
    public static void main(String[] args) {
        System.out.println(divide(0x7FFFFFFF,1));

    }
    public static int divide(int dividend1, int divisor1) {
        boolean sign = true;
        long dividend = dividend1;
        long divisor = divisor1;
        if (dividend == Integer.MIN_VALUE && divisor == -1)return Integer.MAX_VALUE;
        if (dividend<0){
            dividend = (dividend ^ 0xffffffff) +1;
            sign = !sign;
        }
        if (divisor < 0){
            divisor = (divisor ^ 0xffffffff) +1;
            sign = !sign;
        }
        int result = 0;
        long originDivisor = divisor;
        int temp = 1;

        System.out.println(dividend+" "+divisor);
        while (dividend >= divisor) {
            while (dividend >= divisor) {
                divisor = divisor << 1;
                temp = temp << 1;
                if (divisor > Integer.MAX_VALUE/2)break;
            }
            dividend -= divisor>>1;
            divisor = originDivisor;
            result += temp>>1;
            temp = 1;
        }
      if (!sign){
            result = (result ^ 0xffffffff) +1;
        }
        return result;
    }
}
