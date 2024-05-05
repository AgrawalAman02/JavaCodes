package DP;
/*
Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
Determine the maximum value obtainable by cutting up the rod and selling the pieces.
For example : if the length of the rod is 8 and the values of different pieces are given as the following,
              then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20


And if the prices are as follows, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
length  |  1   2   3   4   5   6   7   8
--------------------------------------------
price   | (3)  5   8   9  10  17  17  20

 */
public class D07_RodCutting {
    public static int rod(int[] length, int []price,int totRod){
        int n = length.length;
        int[][] dp = new int[n+1][totRod+1];
        for(int i = 0; i <dp.length;i++){
            for(int j = 0 ; j<dp[0].length; j++){
                if(i ==0|| j==0) dp[i][j] = 0;   // not necessaary as by defalut it is 0 in java
                else{
                    if(length[i-1] <=j){
                        // include
                        int ans1 = price[i-1] + dp[i][j-length[i-1]];
                        //exclude
                        int ans2  = dp[i-1][j];

                        dp[i][j] = Math.max(ans1,ans2);
                    } else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        print(dp);
        return dp[length.length][totRod];

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
        int[] length = {1,2,3,4,5,6,7,8};
        int [] price = {1,5,8,9,10,17,17,20};
//        int totRod = length[length.length-1];
        System.out.println("the max value is "+ rod(length,price,8));
    }

}
