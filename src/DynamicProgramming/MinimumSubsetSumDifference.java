package DynamicProgramming;
/*
* Refer to the following GfG problem:
* https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317*/

class MinimumSubsetSumDifference
{
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int n = arr.length;
        System.out.println(minDifference(arr, n));
    }
    public int minDifference(int arr[], int n)
    {
        // Your code goes here
        int maxSum = 0;
        for(int i: arr)
            maxSum += i;

        List<Integer> list = new ArrayList<>();

        subsetSum(arr, n, maxSum, list);
        int min = Integer.MAX_VALUE;
        for(int sum : list){
            min = Math.min(min, Math.abs(maxSum-2*sum));
        }
        return min;
    }


    public void subsetSum(int[] arr, int n, int sum, List<Integer> list){
        boolean[][] t = new boolean[n+1][sum+1];

        for(int i = 0 ; i <= n ; i++)
            t[i][0] = true;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= sum ; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        for(int i = 0 ; i <= sum/2 ; i++){
            if(t[n][i])
                list.add(i);
        }

    }


}
