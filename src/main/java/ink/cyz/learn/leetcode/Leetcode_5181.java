package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.io.*;

public class Leetcode_5181 {
    @Test
    public void t(){
        int[] t = new int[]{1,2,3,4};
        System.out.println(distanceBetweenBusStops(t,0,3));
    }
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination)return 0;
        int[] d = new int[distance.length*2];
        for (int i = 0; i < distance.length; i++) {
            d[i] = distance[i];
            d[distance.length+i] = distance[i];
        }
        Utils.print(d);
        int len = help(d,start,destination);
        int len2 = help(d,destination,start);
        return Math.min(len,len2);
    }

    private int help(int[] d, int start, int destination) {
        int res = 0;
        if (destination>start){
            for (int i = start; i < destination; i++) {
                res += d[i];
            }
        }else {
            System.out.println(start);
            System.out.println(destination);
            for (int i = destination; i < start; i++) {
                res += d[i];
            }
        }
        return res;
    }
}
