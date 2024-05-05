package DP;

import java.util.Arrays;

public class D04_01Knapsack {

    // recursive method
    public static int knapsack(int[] val,int [] wt,int W, int n){
        if(W == 0|| n==0) return 0;

        if(wt[n-1]<= W) { // 0 based indexing // valid case
            // so we can now either include that one or either exclude that one
            //include case
            int ans1 = val[n-1] + knapsack(val,wt,W-wt[n-1],n-1); // as we are including this case so we will add the value of the item
            //exclude case
            int ans2 = knapsack(val,wt,W,n-1);  // here we are excluding the case so no need to add the value to the ans
            // now we will return the max of the both the ans
            return Math.max(ans1, ans2);
        }
        else{  // exclude case
            // here we will only return the function as we are not taking the case here
            return knapsack(val,wt,W,n-1);
        }
    }

    // Memoization
    public static int knapsackMemo(int[] val,int [] wt,int W, int n,int [][]dp){
        if(W == 0|| n==0) return 0;
        if(dp[n][W]!= -1) return dp[n][W];   // no need to write dp[n-1] as it gives dp[4] but we WANT  dp from 0 to 5 not 4
        if(wt[n-1]<=W){
            int ans1 = val[n-1]+ knapsackMemo(val,wt,W-wt[n-1],n-1,dp);
            int ans2 = knapsackMemo(val,wt,W,n-1,dp);

            dp[n][W] =Math.max(ans1,ans2);

        }
        else
            dp[n][W]=knapsackMemo(val,wt,W,n-1,dp);
        return dp[n][W];
    }

    // tabulation
    public static int knapsackTabu(int[] val, int[]wt , int W , int n){
        int ans = 0;
        int [] [] dp = new int[val.length+1][W+1];
        for(int i =0 ; i<dp.length;i++){
            for(int j = 0 ; j<=W;j++){
                if(i == 0|| j==0) dp[i][j] = 0;
                else {
                    if(wt[i-1]<=j){  // valid
                        // include
                        int ans1 = val[i-1] + dp[i-1][j-wt[i-1]];    // here we include the cost of the that array and add the all the cost of the
                                            // previous array i.e i-1 and if we dont add the weight of i-1 hen the weight will be j - wt
                        // exclude
                        int ans2 =  dp[i-1][j];  // i.e.  we are not including the value
                        dp[i][j] = Math.max(ans1, ans2);
                    } else{
                        dp[i][j] = dp[i-1][j];
                    }

                }
//                ans =  dp[i][j];
            }

        }
        // we can also print the dp array:
        print(dp);
        return dp[n][W];

    }

    public static void print(int[][]dp){
        System.out.println("Printing the Dp array :: ");
        for(int i = 0; i<dp.length;i++){
            for(int j = 0 ; j<dp[0].length;j++){
                System.out.print(dp[i][j] +" \t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] val = {15,14,10,45,30};
        int [] wt = {2,5,1,3,4};
        int W = 7;  // capacity
        System.out.println(knapsack(val,wt,W,5));

        // memoization
        int [][] dp = new int [val.length+1][W+1];
//        Arrays.fill(dp,-1);  this is wrong way to fill array . as arrays.fill is use dto fill 1d array with same eleement
        // To fill a two-dimensional array with a single value, you need to fill each sub-array individually.
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(knapsackMemo(val,wt,W,5,dp));

        System.out.println(knapsackTabu(val,wt,W,val.length));
    }
}
