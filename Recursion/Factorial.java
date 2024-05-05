package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.print("Enter the no to find the factorial :");
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int result = factorial(n);
        System.out.println(result);
    }
    static int factorial(int n){
        if(n==0){
            return 1;
        }
        int fact = n*factorial(n-1);
        return fact;
    }
}
