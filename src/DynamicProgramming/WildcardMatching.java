package DynamicProgramming;

import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "aa", p = "*";
        System.out.println(isMatch(s, p));
    }
    static int[][] dp;
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        dp = new int[n][m];

        for(int[] i: dp)
            Arrays.fill(i, -1);
        return match(p, s, n-1, m-1);
    }
    public static boolean match(String s, String p, int i, int j){

        if(i < 0 && j < 0)
            return true;
        if(i < 0 && j >= 0)
            return false;
        if(i >= 0 && j < 0){
            for(int k = 0 ; k <= i ; k++)
                if(s.charAt(k) != '*') return false;

            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;

        if(s.charAt(i) == '?' || s.charAt(i) == p.charAt(j))
        {
            boolean val = match(s, p, i-1, j-1);
            dp[i][j] = val ? 1 : 0;
            return dp[i][j] == 1;
        }

        if(s.charAt(i) == '*'){
            boolean val = match(s, p, i-1, j) || match(s, p, i, j-1);
            dp[i][j] = val ? 1 : 0;
            return dp[i][j] == 1;
        }

        dp[i][j] = 0;
        return dp[i][j] == 1;
    }
}
