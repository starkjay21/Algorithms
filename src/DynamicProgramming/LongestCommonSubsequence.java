package DynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1="abcsvsfb", text2="desacaccdaf";

        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];
        int lcs_value = longestCommonSubsequence(text1, text2, dp);
        String lcs = getLCS(dp, text1, text2);
        System.out.println(lcs);
        System.out.println(lcs_value);
    }
    public static int longestCommonSubsequence(String text1, String text2, int[][] dp) {
        int n1 = text1.length();
        int n2 = text2.length();

        for(int i = 1 ; i <= n1 ; i++){
            for(int j = 1 ; j <= n2 ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }
    static String getLCS(int[][] dp, String str1, String str2){

        int i = dp.length-1, j = dp[0].length-1;
        String s = "";
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                s = str1.charAt(i-1) + s;
                i--; j--;
            }
            else{
                if(dp[i][j] == dp[i-1][j]){
                    i--;
                } else {
                    j--;
                }
            }
        }
        return s;
    }
}
