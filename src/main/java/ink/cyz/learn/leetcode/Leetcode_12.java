package ink.cyz.learn.leetcode;

import java.util.WeakHashMap;

public class Leetcode_12 {
    public static void main(String[] args) {
        System.out.println(intToRoman2(27));
    }

    public static String intToRoman2(int num){
        int[] arr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        while (num>0){
            for (int i = 0; i < arr.length; i++) {
                if (num>=arr[i]){
                    sb.append(roman[i]);
                    num -= arr[i];
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static String intToRoman(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(getRoman("M","M","M",num/1000));
        num = num-num/1000*1000;
        sb.append(getRoman("C","D","M",num/100));
        num = num-num/100*100;
        sb.append(getRoman("X","L","C",num/10));
        num = num-num/10*10;
        sb.append(getRoman("I","V","X",num));
        return sb.toString();
    }
    public static String getRoman(String i,String v,String x,int num){
        if (num<1||num>9)return "";
        String[] arr = new String[]{i,i+i,i+i+i,i+v,v,v+i,v+i+i,v+i+i+i,i+x};
        return arr[num-1];
    }
}
