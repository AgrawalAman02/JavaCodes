package DP;

public class D13_StrConversion {

    public  static int lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0 ; i<dp.length; i++){
            for(int j = 0 ; j<dp[0].length;j++){
                if(i==0||j==0) dp[i][j] = 0;
                else{
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j] = 1+ dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";
        int n = str1.length()  ;
        int m = str2.length();
        int l = lcs(str1, str2);
        int del = n-l;
        int add = m-l;
        System.out.println("The no. of deletion is : "+ del + " and The no. of insertion is : "+ add);

    }
}
