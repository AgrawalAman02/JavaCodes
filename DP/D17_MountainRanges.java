package DP;

import java.util.Scanner;

public class D17_MountainRanges {

    public static  int ranges(int pairs ){
        int [] dp = new int[pairs+1];
        dp[0] = dp[1] = 1;
        for(int i = 2 ; i< dp.length; i++){
            dp[i] = 0;
            for(int j = 0; j<i; j++){
                // we can also use inside and outside variable seprately and then add
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[pairs];
    }

    public static void main(String[] args) {
        int n ;
        System.out.println("GIve the no. of pair of upstroke and downstroke : ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("The no. of mountain ranges  is : " + ranges(n));
    }
}
