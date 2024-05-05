package DP;

/*
                     *-----------------------*
                     * 44. Wildcard Matching *
                     *-----------------------*
Hard
Topics
Companies
Given an input string (s) and a wildcard pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).



Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

* Input: s = "baaabab", p = "*****ba*****ab"
Output: true

* Input: s = "baaabab", p = "a*ab"
Output: false

Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

 */

public class D14_WildcardMatching {

    public  static  boolean match(String s, String p){
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        // base case:
        // both 0:
        dp[0][0] = true;
        // pattern = " ":
        for(int i = 1; i<n+1;i++){
            dp[i][0] = false;
        }
        // s= " ":
        for(int j = 1; j<m+1;j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }  // no need to do the below as java has default false;
//            else{
//                dp[0][j] = false;
//            }
        }

        // tabulation::
        for(int i = 1 ; i<dp.length;i++){
            for(int j = 1;j<dp[0].length; j++){
                if(p.charAt(j-1) == '?'  ||  s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) =='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else dp[i][j] = false;   // by default false
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "baaabab";
        String str2 = "a*ab";
        String str3 = "*****ba*****ab";

        System.out.println(match(str1,str2));
        System.out.println(match(str1,str3));

    }
}
