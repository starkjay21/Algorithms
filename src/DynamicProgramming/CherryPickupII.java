package DynamicProgramming;

public class CherryPickupII {
    static int[][][] dp;

    public static void main(String[] args) {
        int[][] grid = {
                {3,1,1},
                {2,5,1},
                {1,5,5},
                {2,1,1}
        };
        System.out.println(cherryPickup(grid));
    }
    public static int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n][n];
        for(int i = 0; i < m ; i++)
            for(int j = 0 ; j < n ; j++)
                for(int k = 0 ; k < n ; k++)
                    dp[i][j][k] = -1;

        return pickup(grid, 0, 0, n-1);
    }

    static int pickup(int[][] grid, int row, int c1, int c2){
        int m = grid.length;
        int n = grid[0].length;
        if(c1 < 0 || c2 < 0 || c1 >= n || c2 >= n)
            return (int)-1e8;

        if(row == m-1){
            if(c1 == c2){
                dp[row][c1][c2] = grid[row][c1];
            } else {
                dp[row][c1][c2] = grid[row][c1] + grid[row][c2];
            }
            return dp[row][c1][c2];
        }

        if(dp[row][c1][c2] != -1) return dp[row][c1][c2];

        int max = Integer.MIN_VALUE;

        if(c1 == c2){
            for(int k1 = -1 ; k1 <= 1 ; k1++)
                for(int k2 = -1 ; k2 <= 1 ; k2++)
                    max = Math.max(max, pickup(grid, row+1, c1+k1, c2+k2));

            dp[row][c1][c2] = max + grid[row][c1];
            return dp[row][c1][c2];
        }

        for(int k1 = -1 ; k1 <= 1 ; k1++)
            for(int k2 = -1 ; k2 <= 1 ; k2++)
                max = Math.max(max, pickup(grid, row+1, c1+k1, c2+k2));

        dp[row][c1][c2] = max + grid[row][c1] + grid[row][c2];
        return dp[row][c1][c2];
    }
}
