package DynamicProgramming;

public class LongestCommonSubstring {
    static int[][] dp;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        dp = new int[n + 1][n + 1];
        String l = "";
        for (int i = 0; i < n; i++) {
            l = s.charAt(i) + l;
        }
        int key = lcs(s, l);
        String res = findLCS(s, l, key);
        return res;
    }

    static int lcs(String s, String l) {
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == l.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
            }
        }
        int key = 0;
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                key = Math.max(key, dp[x][y]);
            }
        }
        return key;
    }

    static String findLCS(String s, String l, int key) {
        String lcs = "";
        int n = s.length();
        int i = 0, j = 0;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (dp[x][y] == key) {
                    i = x;
                    j = y;
                }
            }
        }
        while (dp[i][j] != 0) {
            if (s.charAt(i - 1) == l.charAt(j - 1)) {
                lcs = s.charAt(i - 1) + lcs;
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs;
    }
}
