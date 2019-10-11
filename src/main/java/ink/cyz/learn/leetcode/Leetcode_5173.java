package ink.cyz.learn.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Leetcode_5173 {
    public int numPrimeArrangements(int n) {
        long primeNum = getPrimeNum(n);
        long umPrimeNum = n-primeNum;
        return (int) ((f(primeNum)*f(umPrimeNum))%1000000007);
    }

    private long f(long umPrimeNum) {
        long result = 1;
        for (int i = 1; i <= umPrimeNum; i++) {
            result = (result*i) % 1000000007;
        }
        return  result;
    }



    private int getPrimeNum(int n) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            if (i == 2)list.add(i);
            else {
                for (int j = 0; j < list.size(); j++) {
                    if (i % list.get(j) == 0){
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)list.add(i);
            }
        }

        return list.size();
    }
}
