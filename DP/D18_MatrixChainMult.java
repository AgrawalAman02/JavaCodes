package DP;

import java.util.Arrays;

/*
Matrix Chain Multiplication | DP-8
-----------------------------------------
Given the dimension of a sequence of matrices in an array arr[], where the dimension of the ith matrix is (arr[i-1] * arr[i]),
the task is to find the most efficient way to multiply these matrices together such that the total number of element multiplications is minimum.

Examples:

Input: arr[] = {40, 20, 30, 10, 30}
Output: 26000
Explanation:There are 4 matrices of dimensions 40×20, 20×30, 30×10, 10×30.
Let the input 4 matrices be A, B, C and D.
The minimum number of  multiplications are obtained by
putting parenthesis in following way (A(BC))D.
The minimum is 20*30*10 + 40*20*10 + 40*10*30

Input: arr[] = {1, 2, 3, 4, 3}
Output: 30
Explanation: There are 4 matrices of dimensions 1×2, 2×3, 3×4, 4×3.
Let the input 4 matrices be A, B, C and D.
The minimum number of multiplications are obtained by
putting parenthesis in following way ((AB)C)D.
The minimum number is 1*2*3 + 1*3*4 + 1*4*3 = 30

Input: arr[] = {10, 20, 30}
Output: 6000
Explanation: There are only two matrices of dimensions 10×20 and 20×30.
So there  is only one way to multiply the matrices, cost of which is 10*20*30
 */
public class D18_MatrixChainMult {
    public static int mcm(int [] arr, int i , int j){
        if(i==j ) return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int cost1  = mcm(arr,i,k);  // Ai .... Ak => arr[i-1] x arr[k]
            int cost2 = mcm(arr, k+1, j); //Ai+1.....Aj => arr[k] x arr[j]
            int cost = arr[i-1]*arr[k] * arr[j];

            int finalans = cost+ cost1+cost2;
            ans =  Math.min(ans,finalans);
        }
        return ans;
    }

    public static int mcmMemo(int [] arr, int i , int j, int[][] dp){
        if(i==j ) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int cost1  = mcmMemo(arr,i,k,dp);  // Ai .... Ak => arr[i-1] x arr[k]
            int cost2 = mcmMemo(arr, k+1, j,dp); //Ai+1.....Aj => arr[k] x arr[j]
            int cost = arr[i-1]*arr[k] * arr[j];

            int finalans = cost+ cost1+cost2;
            ans =  Math.min(ans,finalans);

        }
        return dp[i][j] = ans;
    }

    public static int mcmTabu(int [] arr){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //initialisation
        for(int i =0 ; i<n;i++){
            dp[i][i] = 0;
        }

        // bottom up
        for(int len = 2; len <= n-1; len++ ){
            for(int i = 1; i<=n-len; i++){
                int j = i+len-1; //col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k<= j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];

                    dp[i][j] = Math.min(dp[i][j],cost3+cost1+cost2 );
                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }
    public static void print(int[][]dp){
        System.out.println("Printing the Dp array (if u want) ::::::: :::::::: ");
        for(int i = 0; i<dp.length;i++){
            for(int j = 0 ; j<dp[0].length;j++){
                System.out.print(dp[i][j] +" \t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        System.out.println(mcm(arr, 1,n-1));
        int [][] dp = new int[n][n];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        System.out.println(mcmMemo(arr,1,n-1,dp));
        System.out.println(mcmTabu(arr));


    }
}
