package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FrogJumpKSteps {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] heights = new int[n+1];
        for (int i = 1; i <= n; i++) {
            heights[i] = sc.nextInt();
        }
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(findMinEnergy(heights, n, k));
    }

    public static int findMinEnergy(int[] heights, int index, int k) {
        if (index == 1)
            return 0;

        if(dp[index] != -1)
            return dp[index];

        int minEnergy = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            int tempIndex = index - j;
            if (tempIndex < 1)
                break;

            minEnergy =
                    Math.min(minEnergy,
                    findMinEnergy(heights, tempIndex, k) + Math.abs(heights[index]-heights[tempIndex]));
        }
        dp[index] = minEnergy;
        return dp[index];
    }
}
