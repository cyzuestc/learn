package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_115 {
    /*
    s rabbbit
    t rabbit
     */

    @Test
    public void t(){
        int res = numDistinct("xslledayhxhadmctrliaxqpokyezcfhzaskeykchkmhpyjipxtsuljkwkovmvelvwxzwieeuqnjozrfwmzsylcwvsthnxujvrkszqwtglewkycikdaiocglwzukwovsghkhyidevhbgffoqkpabthmqihcfxxzdejletqjoxmwftlxfcxgxgvpperwbqvhxgsbbkmphyomtbjzdjhcrcsggleiczpbfjcgtpycpmrjnckslrwduqlccqmgrdhxolfjafmsrfdghnatexyanldrdpxvvgujsztuffoymrfteholgonuaqndinadtumnuhkboyzaqguwqijwxxszngextfcozpetyownmyneehdwqmtpjloztswmzzdzqhuoxrblppqvyvsqhnhryvqsqogpnlqfulurexdtovqpqkfxxnqykgscxaskmksivoazlducanrqxynxlgvwonalpsyddqmaemcrrwvrjmjjnygyebwtqxehrclwsxzylbqexnxjcgspeynlbmetlkacnnbhmaizbadynajpibepbuacggxrqavfnwpcwxbzxfymhjcslghmajrirqzjqxpgtgisfjreqrqabssobbadmtmdknmakdigjqyqcruujlwmfoagrckdwyiglviyyrekjealvvigiesnvuumxgsveadrxlpwetioxibtdjblowblqvzpbrmhupyrdophjxvhgzclidzybajuxllacyhyphssvhcffxonysahvzhzbttyeeyiefhunbokiqrpqfcoxdxvefugapeevdoakxwzykmhbdytjbhigffkmbqmqxsoaiomgmmgwapzdosorcxxhejvgajyzdmzlcntqbapbpofdjtulstuzdrffafedufqwsknumcxbschdybosxkrabyfdejgyozwillcxpcaiehlelczioskqtptzaczobvyojdlyflilvwqgyrqmjaeepydrcchfyftjighntqzoo","brwmima");
        System.out.println(res);
    }
    public int numDistinct(String s, String t) {
        dp =  new int[s.length()+1][t.length()+1];
        int res = help(s,0,t,0);
        return res;
    }
    int[][] dp ;

    private int help(String s, int i, String t, int j) {
        if (dp[i][j] == -1)return 0;
        if (dp[i][j] != 0)return dp[i][j];

        if (t.length() == j){
            dp[i][j] = 1;
            return 1;
        }
        if (s.length() == i || t.length() == j || s.length()-i < t.length() -j){
            dp[i][j] = -1;
            return 0;
        }
        int cur = 0;
        int next = 0;
        if (s.charAt(i) == t.charAt(j)){
            cur = help(s,i+1,t,j+1);
        }
        next = help(s,i+1,t,j);

        dp[i][j] = cur+next;

        return dp[i][j];
    }
}
