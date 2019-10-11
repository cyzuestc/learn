package ink.cyz.learn.leetcode;

import org.junit.Test;

public class MajorityChecker {
    public static void main(String[] args) {

        MajorityChecker majorityChecker = new MajorityChecker(new int[]{1,1,2,2,1,1});
        System.out.println(majorityChecker.query(0,5,4)); // returns 1
        System.out.println(majorityChecker.query(0,3,3)); // returns -1
        System.out.println(majorityChecker.query(2,3,2));// returns 2
    }
    int[] arr ;
    String[][] dp;
    public MajorityChecker(int[] arr) {
        this.arr = arr;
        dp=new String[arr.length][arr.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = "";
            }
        }
    }

    public int query(int left, int right, int threshold) {
        if (!dp[left][right].isEmpty()){
            if (dp[left][right].equals("-1"))return -1;
            if (Integer.parseInt(dp[left][right].split(",")[0])>=threshold)
            return Integer.parseInt(dp[left][right].split(",")[1]);
            else return -1;
        }
        int wait = arr[left];
        int ticket = 1;
        for (int i = left+1; i <= right; i++) {
            if (arr[i] == wait)ticket++;
            else {
                if (ticket >0)ticket--;
                else if (ticket == 0){
                    wait = arr[i];
                    ticket = 1;
                }
            }
        }
        if (ticket == 0){
            dp[left][right] = "-1";
            return -1;
        }
        ticket = 0;
        for (int i = left; i <=right ; i++) {
            if (arr[i] == wait)ticket++;
        }

        if (ticket>=threshold){
            dp[left][right] = ticket+","+wait;
            return wait;
        }
        dp[left][right] = "-1";
        return -1;
    }

}
