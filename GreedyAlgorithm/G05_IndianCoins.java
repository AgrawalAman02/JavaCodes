package GreedyAlgorithm;


import java.util.*;

/*
We are given an infinite supply of denominations [1,2,5,10,20,50,100,500,2000]. find min no. coins/notes to make change for a value V

V = 121
ans = 3 (100+20+1)

V= 590
ans 4(500+50+20+10)

==>> Greedy approach is not applicable to all coin system. it is applicable to only canonical system
    indian coin system is canonical system


 */
public class G05_IndianCoins {
    public static void main(String[] args) {
        int coins[] = {1,2,5,10,20,50,100,500,2000};
        int val = 1059;
        int change = 0;
        // we can also sort the coins array in descending order
//        Arrays.sort(coins, Comparator.reverseOrder());  // throws error if u use coins as int , u have to  use Integer object not primitive data type i.e. Integer coins[] =
        for(int i = coins.length-1; i>=0;i--){
            while(coins[i] <= val){   // tbtk chalana h jbtk amount barabar ho jaye  i.e. as long as val>0
                val-=coins[i];
                change++;
                System.out.println("Used coin is " + coins[i]);  // we can also use an arraylist to store coins  if not want to print
            }


        }

        System.out.println("the no. of change required for the val is "+ change);
    }
}
