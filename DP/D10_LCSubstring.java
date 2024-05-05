package DP;
/*
            Longest common Substring
          *--------------------------*
A substring is a contiguous sequence of character within a string....
S1 = "ABCDE" S2 = "ABGCE"
ANS = 2
 */
public class D10_LCSubstring {
    public static int substring(String str1, int n, String str2, int m, int count){
        if(n==0||m==0)  return count;

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            count = Math.max(count, substring(str1,n-1,str2,m-1, count+1));
        } else{
            count = Math.max(count, Math.max(substring(str1,n-1, str2, m, 0), substring(str1, n, str2, m-1, 0)));
        }
        return count;
    }
    public static int substringTabu(String str1, String str2){
        int n  = str1.length();
        int m = str2.length();
        int [][]dp = new int[n+1][m+1];
        int count = 0;
        for(int i =1 ; i<dp.length;i++){  // starting with 1 as by default the value are 0 . and we want the base condition to be 0 so no need to specify it again.
            for (int j = 1 ; j<dp[0].length;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    count = Math.max(count, dp[i][j]);
                }else{
                    dp[i][j] = 0;  // as we are storing the LCS in i,j
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str1 = "abcdgh";
        String str2 = "acdghr";
        int n = str1.length();
        int m = str2.length();
        System.out.println(substring(str1,n,str2,m,0));
        System.out.println(substringTabu(str1,str2));
    }
}
