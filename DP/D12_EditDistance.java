package DP;
/*
                  *---------------------*
                  *  72. Edit Distance  *
                  *---------------------*

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class D12_EditDistance {

    public static int opRecu(String str1, int n , String str2, int m){
        if(n==0) return m;
        if(m== 0) return n;

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return opRecu(str1, n-1, str2, m-1);
        } else{
            int add = 1+ opRecu(str1,n,str2, m-1);
            int delete = 1+ opRecu(str1, n-1, str2, m);
            int replace = 1+ opRecu(str1, n-1, str2,m-1);

            return Math.min(add,Math.min(delete,replace));
        }
    }

    public  static int operation(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int [][] dp = new int[n+1][m+1];
        for(int i = 0; i<dp.length; i++){
            for (int j = 0;j<dp[0].length;j++){
                // initialisation
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else{
                    //botttom up / tabulation :::
                    if (str1.charAt(i-1)== str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    } else{
                        int add = dp[i][j-1] +1;
                        int delete = dp[i-1][j]+1;
                        int replace= dp[i-1][j-1]+1;
                        dp[i][j] = Math.min(add,Math.min(delete,replace));
                    }
                }
            }
        }
        return  dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";

        System.out.println(operation(str1,str2));
        System.out.println(opRecu(str1, str1.length(),str2,str2.length()));
    }
}
