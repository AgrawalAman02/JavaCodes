package Recursion;

import java.util.Scanner;

public class XpowerN {
    public static void main(String[] args) {
        System.out.println("enter the base:");
        Scanner sc = new Scanner(System.in);
        int b= sc.nextInt();
        System.out.println("enter the power: ");
        int p = sc.nextInt();
       System.out.println(power(b,p,0));

//        we can use x^n= x*x^(n-1);
        System.out.println(power(b,p));

    }
    static int power(int a, int n,int i){
        if(i==n){
            return 1;
        }
        int value = a*power(a,n,i+1);
        return value;
    }
        
//        orrrrrrrrrrrrrrrrrrrrrrrrr

    static int power(int a, int n){
        if(n==0){
            return 1;
        }
        int value = a*power(a, n-1);
        return value;
        
    }
}
// time complexity O(n);