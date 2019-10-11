package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_321 {
    @Test
    public void t(){
        int[] n1 = {2,5,6,4,4,0};
        int[] n2 = {7,3,8,0,6,5,7,6,2};
        maxNumber(n1,n2,15);
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        String s1 = generateS(nums1);
        String s2 = generateS(nums2);
        String[] dp1 = generateDp(s1);
        String[] dp2 = generateDp(s2);

        String maxNum = "";
        for (int i = 0; i <= k; i++) {
            if (i<dp1.length&&k-i<dp2.length){
                if (maxNum.equals(""))maxNum =generateMaxNum(dp1[i],dp2[k-i]);
                else{
                    String temp = generateMaxNum(dp1[i],dp2[k-i]);
                    if (maxNum.compareTo(temp) < 0)maxNum = temp;
                }
            }
        }
        System.out.println(maxNum);
        int[] res = new int[k];
        for (int i = k-1; i >=0 ;i--) {
            res[i] = maxNum.charAt(i)-'0';
        }
        return res;
    }

    private String generateMaxNum(String s, String s1) {
//        System.out.println(s);
//        System.out.println(s1);
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i<s.length() && j<s1.length()){
            if (s.substring(i).compareTo(s1.substring(j)) > 0){
                res.append(s.charAt(i));
                i++;
            }else {
                res.append(s1.charAt(j));
                j++;
            }
        }
        while (i<s.length()){
            res.append(s.charAt(i));
            i++;
        }
        while (j<s1.length()){
            res.append(s1.charAt(j));
            j++;
        }
        return res.toString();
    }

    private String generateS(int[] nums1) {
        StringBuilder s = new StringBuilder();
        for (int n : nums1)s.append(n);
        return s.toString();
    }


    private String generateSubStr(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) < s.charAt(i+1))return s.substring(0,i)+s.substring(i+1);
        }
        return s.substring(0,s.length()-1);
    }

    private String[] generateDp(String s) {
        String[] dp = new String[s.length()+1];
        while (!s.isEmpty()){
            dp[s.length()] = s;
            s = generateSubStr(s);
        }
        dp[0] = "";
        return dp;
    }


}
