package Recursion;

import java.util.Scanner;

public class DecreasingNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. from which u want decreasing no.");
        int n = sc.nextInt();
        decreasing(n);
    }

   public static void decreasing(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
            System.out.println( n+" ");
            decreasing(n-1);

    }
}

