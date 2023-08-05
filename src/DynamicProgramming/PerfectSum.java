package DynamicProgramming;

import java.util.Arrays;

public class PerfectSum {
    public static void main(String[] args) {
        int[] arr = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        int sum = 31;
        System.out.println(perfectSum(arr, arr.length, sum));
    }
    public static int perfectSum(int[] arr, int n, int sum)
    {
        // Your code goes here
        int[][] t = new int[n+1][sum+1];
        for(int i = 0 ; i <= n ; i++){
            t[i][0] = 1;
        }
        Arrays.sort(arr);
        int MOD = 1000000007;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= sum ; j++){
                if(arr[i-1] <= j){
                    t[i][j] = (t[i-1][j-arr[i-1]]%MOD + t[i-1][j]%MOD);
                } else {
                    t[i][j] = t[i-1][j]%MOD;
                }
            }
        }

        return t[n][sum];
    }
}
