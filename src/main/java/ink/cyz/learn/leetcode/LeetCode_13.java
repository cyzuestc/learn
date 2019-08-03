package ink.cyz.learn.leetcode;

public class LeetCode_13 {
    public static void main(String[] args) {
        String s ="MCMXCIV";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        int[] num = {1,5,10,50,100,500,1000};
        char[] roman = {'I','V','X','L','C','D','M'};
        int[] map = new int[26];
        for (int i = 0; i < roman.length; i++) {
            map[roman[i]-'A'] = num[i];
        }
        int res = 0;
        int i = 0;
        while (i<s.length()){
            char cur = s.charAt(i);
            //不是最后一位
            if (i<s.length()-1){
                char next = s.charAt(i+1);
                //当前字符大于下一位字符
                if (map[cur-'A']>=map[next-'A']){
                    res += map[cur-'A'];
                    i++;
                    //当前字符小于下一位字符
                }else {
                    res += (map[next-'A']-map[cur-'A']);
                    i+= 2;
                }
            }else if(i == s.length()-1){
                res += map[s.charAt(i)-'A'];
                i++;
            }
        }

        return res;
    }
}
