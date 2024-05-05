package DP;

import java.util.Scanner;

/*
            * Counting Trees *
            * -------------- *
Find no. of all possible BSTs with given n nodes.
* n = 3 (10, 20, 30)
* ans = 5
*
* Total number of possible Binary Search Trees with n different keys (countBST(n)) = Catalan number Cn = (2n)! / ((n + 1)! * n!)

For n = 0, 1, 2, 3, … values of Catalan numbers are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …. So are numbers of Binary Search Trees.

Total number of possible Binary Trees with n different keys (countBT(n)) = countBST(n) * n!           (ye formula pta nh smjh nh aaa rha h , pr ye question catalan se bnega sure)
* so we are using the logic of catalan here for the countingBst
 * */
public class D16_Counting_Trees {

    public static int countBst(int n){
        int ans =0;
        int []dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int  i = 2 ; i<dp.length;i++){  // loop for filling the dp array
            dp[i] = 0;
            for(int j = 0 ; j < i; j++){   // loop for finding the catalan of dp[i];
//                dp[i] += dp[j]*dp[i-j-1];
                // we can also write as
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n;
        System.out.println("enter the  no. of the nodes of the trees : ");
        Scanner sc =   new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("The no. of the bst from given no. of nodes  is : "+ countBst(n));   // T.C = O(N^2);
    }
}
