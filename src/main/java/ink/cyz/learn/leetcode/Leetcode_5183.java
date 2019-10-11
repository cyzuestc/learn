package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Leetcode_5183 {
    @Test
    public void t(){
        System.out.println(dayOfTheWeek(8,9,2019));
    }
    public String dayOfTheWeek(int day, int month, int year) {
        String[] w = {"Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
//        1971 1 1 周五
        int interval = 0;
        for (int i = 1971; i < year; i++) {
            interval += (i%4==0?366:365);
        }
        int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (year%4==0)m[1] = 29;
        for (int i = 0; i < month-1; i++) {
            interval += m[i];
        }
        for (int i = 1; i < day; i++) {
            interval++;
        }
        System.out.println(w[interval%7]);
        return w[interval%7];
    }
}
