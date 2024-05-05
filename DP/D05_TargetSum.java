package DP;

/*
       ***** TARGET SUM *****
it is a variation of the 0-1 knapsack

numbers[] = 4,2,7,1,3
Target Sum = 10
 */

public class D05_TargetSum {

    public static boolean targetSum(int [] arr, int sum){
        int n = arr.length;
        boolean [][] dp = new boolean[n+1][sum+1];
        // i = items; j = target sum
        for(int i = 0; i<=n; i++){
            dp[i][0] = true;
        }
        // we can also initialise that in the dp wala loop as knapsack problem
        for (int i = 1 ; i<dp.length; i++){ // as already defined base case above so start loop by 1
            for(int j  = 1 ; j <dp[0].length; j++){
                int v = arr[i-1];
                // include
                if(v<= j && dp[i - 1][j - v]){
                    dp[i][j] = true;
                }
                // exclude
                else if(dp[i - 1][j]){
                    dp[i][j] = true;  // as we not included the item so it will remain true
                }
            }

        }

        print(dp);
        return dp[n][sum];
    }
    public static void print(boolean [][] dp){
        System.out.println("Printing the Dp array :: ");
        for(int i = 0; i<dp.length;i++){
            for(int j = 0 ; j<dp[0].length;j++){
                System.out.print(dp[i][j] +"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = {4,2,7,1,3};
        int sum = 10;
        System.out.println(targetSum(arr,sum));
    }
}
