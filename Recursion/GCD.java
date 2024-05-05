package Recursion;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        // brute force approach or normal approach
        /*
        System.out.println("enter two no.:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd;
        int min;
        if(a>b) min = a;
        else min = b;
        for(int i= min-1;i>=1;i--){
            if(a%i==0&& b%i==0){
                System.out.println("gcd of a and b is "+ i);
                break;
            }
        }
        // time complexity is O(min) which is high
         */

        // by long division method using iteration
        System.out.println("enter two no.:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(iGcd(a,b));  // iterative

        // recursive
        System.out.println(rGcd(a,b));

    }
    static int iGcd(int a, int b){
        int rem;
        while(a%b!=0){
            rem= a % b;
            a = b;
            b =rem;

        }
        return b;
    }

    static  int rGcd(int x, int y){
        if(y==0){
            return x;
        }
        return rGcd(y,x%y);
    }
}

// for finding LCM we use this formula [ lcm * hcf = x*y ]
//so lcm = (x*y)/hcf
