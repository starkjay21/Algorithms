package DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
    static int[][] dp;
    public static int minCut(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] i: dp) Arrays.fill(i, -1);

        return helper(s, 0, n-1);
    }

    static int helper(String s, int i, int j){
        if(i == j){
            dp[i][j] = 0;
            return dp[i][j];
        }
        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE, ans;
        for(int k = i ; k < j ; k++){
            if(!isPalindrome(s, i, k)) continue;

            ans = 1 + helper(s, i, k) + helper(s, k+1, j);
            min = Math.min(min, ans);
        }
        dp[i][j] = min;
        return dp[i][j];
    }
    static boolean isPalindrome(String s, int left, int right){
        while(left <= right)
            if(s.charAt(left++) != s.charAt(right--))
                return false;

        return true;
    }
}
