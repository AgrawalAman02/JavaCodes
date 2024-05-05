package DP;

import java.util.Arrays;

/*

                        1143. Longest Common Subsequence
                       *--------------------------------*
(Medium))
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abcdge", text2 = "abedg"
Output: 4
Explanation: The longest common subsequence is "abdg" and its length is 4.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0
 */
public class D08_LCS {

    public static int subsequence(String str1, int n, String str2, int m){
        if(n==0||m==0)  return 0;

        if(str1.charAt(n-1) == str2.charAt(m-1)) {

            return 1+subsequence(str1,n-1,str2,m-1);
        } else{
            int ans1 = subsequence(str1,n-1, str2, m);
            int ans2  = subsequence(str1, n, str2, m-1);
            return Math.max(ans1,ans2);
        }
    }

    public static int subsequenceMemo(String str1, int n , String str2, int m , int[][]dp){
        if(n==0||m==0)  return 0;
        if(dp[n][m]!=-1) return dp[n][m];

        if(str1.charAt(n-1) == str2.charAt(m-1)) {

            dp[n][m]= 1+subsequenceMemo(str1,n-1,str2,m-1,dp);
        } else{
            int ans1 = subsequenceMemo(str1,n-1, str2, m,dp);
            int ans2  = subsequenceMemo(str1, n, str2, m-1,dp);
            dp[n][m]= Math.max(ans1,ans2);
        }
        return dp[n][m];
    }

    public static int subsequenceTabu(String str1,int n,String str2, int m){
        int[][]dp = new int[n+1][m+1];
        for(int i =0;i<dp.length;i++){
            for(int j = 0; j<dp[0].length;j++){
                if(i==0||j==0) dp[i][j] = 0;
                else{
                    if(str1.charAt(i-1) == str2.charAt(j-1)) {

                        dp[i][j]= 1+dp[i-1][j-1];
                    } else{
                        int ans1 = dp[i-1][j];
                        int ans2  = dp[i][j-1];
                        dp[i][j]= Math.max(ans1,ans2);
                    }
                }
            }
        }
        print(dp);
        return dp[n][m];

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
        String str1 ="abcdge";
        String str2= "abedg";
        System.out.println(subsequence(str1,str1.length(),str2,str2.length()));
        int [][]dp = new int[str1.length()+1][str2.length()+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        System.out.println(subsequenceMemo(str1,str1.length(),str2,str2.length(),dp));
        System.out.println(subsequenceTabu(str1,str1.length(),str2,str2.length()));
    }
}
