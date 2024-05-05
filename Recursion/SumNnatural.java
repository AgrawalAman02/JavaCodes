package Recursion;

import java.util.Scanner;

public class SumNnatural {
    public static void main(String[] args) {
        System.out.print("enter the no. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("the sum is "+ sumNatural(n));
    }
    static int sumNatural(int n){
        if(n==1){
            return 1;
        }
        int sum = n+ sumNatural(n-1);
        return sum;
    }
}
