package DP;

import java.util.Arrays;
import java.util.HashSet;

/*
            Longest increasing Subsequence
           *------------------------------*
 */
public class D11_LIS {
    public static  int lcs(int [] arr, int [] arr2){
        int n = arr.length;
        int m = arr2.length;
        int [][] dp = new int[n+1][m+1];
        for(int i = 1; i<dp.length;i++){
            for(int j = 1 ; j<dp[0].length;j++){
                if(arr[i-1] == arr2[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int sub(int[] arr){
        HashSet<Integer> set = new HashSet<>()  ;
        for(int i = 0; i<arr.length;i++){
            set.add(arr[i]);
        }

        int arr2[]  = new int[set.size()];
        int i = 0;
        for (int num: set){
            arr2[i] = num;
            i++;

        }
        Arrays.sort(arr2);
        return lcs(arr,arr2);
    }
    public static void main(String[] args) {
        int [] arr= {50,3,10,7,40,80};

        int  n = arr.length;
        System.out.println(sub(arr));

    }
}
