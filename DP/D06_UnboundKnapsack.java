package DP;

public class D06_UnboundKnapsack {
    public static int UnbknapsackTabu(int[] val, int[]wt , int W , int n){
        int ans = 0;
        int [] [] dp = new int[val.length+1][W+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<=W; j++){
            dp[0][j] = 0;
        }
        for(int i =1 ; i<dp.length;i++){
            for(int j = 1 ; j<=W;j++){
                if(wt[i-1]<=j){  // valid
                    // include
                    int ans1 = val[i-1] + dp[i][j-wt[i-1]];   // only change is here  i,e, we took dp[i] instead of i-1
                    // exclude
                    int ans2 =  dp[i-1][j];  // i.e.  we are not including the value
                    dp[i][j] = Math.max(ans1, ans2);
                } else{
                    dp[i][j] = dp[i-1][j];
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

        System.out.println(UnbknapsackTabu(val,wt,W,val.length));
    }
}
