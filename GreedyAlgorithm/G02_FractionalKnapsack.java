package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/*
knapsack = bori

Give the weights and the value of N items , put these items  in a knapsack of capacity W
to get the maximum total value in the knapsack.

value = [60, 100, 120]
weight = [10,20,30]
W = 50


====>>>>>
    so we do want that the weight should be more and value should be more
    so we take  a ratio = value / weight
    where ratio is more in both case if value more or weight less
    so we want the more ratio
 */
public class G02_FractionalKnapsack {

    public static void main(String[] args) {
        int val[] = {60,100,120};
        int[] weight = {10,20,30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
        // 0th col = idx; 1st col = ratio

        for(int i = 0 ; i<val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/ (double)weight[i];
        }

        //Ascending Order
        Arrays.sort(ratio, Comparator.comparingDouble(o-> o[1]));
        // for descending order we will use loop in reverse order

        int capacity = W;
        int finalVal = 0 ;
        for(int i = ratio.length-1; i>= 0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){  // including the full item
                finalVal += val[idx];
                capacity -= weight[idx];

            }else {
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;

            }

        }
        System.out.println("final value - " + finalVal);


    }

}
