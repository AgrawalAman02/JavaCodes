package DP;
/*
           * Minimum Partitioning *
           *----------------------*

 */
public class D19_MinimumPartitioning {

    public static int knapsack(int [] num, int W){
        int n= num.length;
        int [][] dp = new int[n+1][W+1];
        for(int i =1 ;i<dp.length;i++){
            for(int j = 1; j<dp[0].length;j++){
//                if(i==0 || j== 0) dp[i][j] = 0;
                if(num[i-1] <=j){
                    // include
                    dp[i][j] = Math.max(num[i-1]+dp[i-1][j-num[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]= dp[i-1][j];
                }

            }
        }
        return dp[n][W];
    }

    public static  int minDiff(int[] num){
        int n = num.length;
        int sum = 0;
        for(int i = 0;i<num.length; i++){
            sum +=num[i];
        }
        int W = sum/2;
        int sum1 = knapsack(num,W);
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);
         /*
        in another variation where it is asked min diff is 0;
        so we check if sun1 == sum/2 , if yes then we can say it is possible
        but if not , then we say that the min diff ==0 is not possible;
         */
    }

    public static void main(String[] args) {
        int [] num = {1,6,11,5};
        System.out.println(minDiff(num));
        // t.c O(n*W)
    }
    
}
