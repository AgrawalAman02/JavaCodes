package Loops;

import java.util.Scanner;

public class PrimeOptimised {
    public static boolean isPrime(int n){
        if(n==2){
            return true;

        }
        for(int i=2 ;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    /*public static void PrimeInRange(int n){
        for(int i=2;i<=n;i++){
            if(isPrime(i)){  // = true
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }*/
    public static void main(String[] args) {
        System.out.print("enter the no. to check whether it is prime: - ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("its "+isPrime(n));

//        System.out.println("print all the prime no. upto 20");
//        PrimeInRange(20);
    }
}
