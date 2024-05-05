package DP;

import java.util.Arrays;

/*

Catalan numbers are defined as a mathematical sequence that consists of positive integers,
 which can be used to find the number of possibilities of various combinations.

The nth term in the sequence denoted Cn, is found in the following formula: \frac{(2n)!}{((n + 1)! n!)}

The first few Catalan numbers for n = 0, 1, 2, 3, … are : 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
 */
public class D15_CatalansNumber {

    public static long catalanRecu(int n) {
        if (n <= 1) {
            return 1;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += catalanRecu(i) * catalanRecu(n - i - 1);
        }
        return res;
    }

    public static  long catalunMemo(int n, long []dp){
        if (n <= 1) {
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        else{
             int ans = 0;
            for(int i = 0; i<n; i++){
                ans += catalunMemo(i,dp)*catalunMemo(n-i-1, dp);
            }
            dp[n] = ans;
        }
        return dp[n];
    }

    public static long catalunTabu(int n){
        long [] dp = new long[n+1];
        dp[0]= dp[1] = 1;
        dp[n] = 0;
        for(int i =2;i<dp.length;i++){    // since we have to find the catalan of each no. of dp array so we are doing this loop
            // since we have to find the cat of 2  , so we will take a loop of 0 to 1 ,
            // similarly for c(5) we have to take a looop for finding the C form 0 to 4;
            int ans = 0;  // dp[i] = 0 we can also write this
            for(int j = 0; j<i;j++){   // since for each no's(i) catalan we require a loop , so this is that loop
                ans += dp[j]*dp[i-j-1];
            }
            dp[i] = ans;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n =5;
        // we cant able to find the value for the n = 30 using recursion
        System.out.println(catalanRecu(n));
        long [] dp = new long[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalunMemo(n,dp));   // there is a stack overflow issue here so we use tabulation . as memo uses stack for the recursion
        System.out.println(catalunTabu(1000));
    }
}
