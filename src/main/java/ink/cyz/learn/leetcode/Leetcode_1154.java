package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_1154 {
    @Test
    public void t(){
        System.out.println(dayOfYear("2004-03-01"));
    }
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);
        boolean isR = (year%4==0);
        if (year%100==0)isR= (year%400==0);
        int[] d = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (isR)d[1] = 29;
        int count = 0;
        for (int i = 0; i < month-1; i++) {
            count+= d[i];
        }
        count+= day;
        return count;
    }

}
