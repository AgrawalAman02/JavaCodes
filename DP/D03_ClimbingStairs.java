package DP;
/*
Count ways to reach nth stairs. The person can climb either 1 stair or 2 stair at a time;

 */

import java.util.Arrays;

public class D03_ClimbingStairs {
    public static int countWays(int n){  // t.c. = O(2^n)
        if(n== 0 ) return 1;
        else if(n<0) return 0;
        else return countWays(n-1)+ countWays(n-2);
    }
    public static int countWaysMemo(int n, int[]dp){  // t.c = O(n)  big relief
        if(n==0) return 1;
        else if(n<0) return 0;


        else if(dp[n]!=-1) return dp[n];
        else{
            dp[n] = countWaysMemo(n-1,dp)+ countWaysMemo(n-2,dp);
            return dp[n];
        }
    }

    public static int countWaysTabu(int n){  // t.c = O(n)  big relief
        int [] dp = new int[n+1];
        dp[0]= 1;

        for(int i = 1; i<=n;i++){
            if(i==1) {
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+ dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n  = 5;
        System.out.println("The  ways to reach "+ n + " stairs is "+ countWays(n));
        int [] dp = new int[n+1];  // by default it fill 0 at all place
//        if we want to fill -1 at all place then  we can do below
        Arrays.fill(dp,-1);  // its not necessary , if we do it with 0 filling then it will also be ok
        System.out.println("The  ways to reach "+ n + " stairs is "+ countWaysMemo(n,dp));
        System.out.println("The  ways to reach "+ n + " stairs is "+ countWaysTabu(n));
    }
}
