package Recursion;

import java.util.Scanner;

public class NthFibonacci {
    public static void main(String[] args) {
        System.out.println("enter the term whose fibonacci u want : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fibo=fibonacci(n);
        System.out.println(fibo);

    }
    static int fibonacci(int n){
        if(n==1|| n==2){
            return 1;
        }
        int Nm2= fibonacci(n-2);
        int Nm1= fibonacci(n-1);
        return Nm1+Nm2;
    }
}
