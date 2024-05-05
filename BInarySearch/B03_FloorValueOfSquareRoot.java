package BInarySearch;

import java.util.Scanner;

public class B03_FloorValueOfSquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value whose floor value of the square root u have to find : ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        int lo = 0;
        int hi = arr.length-1;
        int val = -1;
        while(lo<= hi){
            int mid = lo + ( hi - lo)/2 ;
            if(mid*mid == n) val = mid;
            else if(mid * mid > n){
                hi = mid - 1;

            } else {
                lo = mid +1;
                val = mid;
            }
        }
        System.out.println("The floor value of the square root of the "+ n+" is "+ val);
    }
}
