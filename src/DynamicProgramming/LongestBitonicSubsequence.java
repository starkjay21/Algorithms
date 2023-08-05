package DynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {100,92,89,77,74,66,64,66,64};
        System.out.println(minimumMountainRemovals(nums));;
    }
    public static int minimumMountainRemovals(int[] nums) {
        int lenLBS = lbs(nums);
        return nums.length-lenLBS;
    }
    public static int lbs(int[] nums){
        int n = nums.length;
        int[] dp1 = lis(nums);
        int[] dp2 = lds(nums);
        int max = 1;
        for(int i = 1 ; i < n-1 ; i++){
            max = Math.max(max, dp1[i]+dp2[i]-1);
        }
        return max;
    }

    public static int[] lis(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
        }

        return dp;
    }

    public static int[] lds(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = n-1 ; j > i ; j--){
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
        }

        return dp;
    }
}
