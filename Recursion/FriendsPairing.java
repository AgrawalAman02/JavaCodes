//Given n friend , each one remain single or can be paired up with soe other friend .
//Each friend can be paired only once . Find out he total number of ways in which
//friends can remain single or can be paired up.
package Recursion;

import java.util.Scanner;

public class FriendsPairing {
    public static int friendsPairing(int n){
        if(n==1|| n==2){
            return n;
        }
//        choice
//        single
        int fnm1 = friendsPairing(n-1);

//        pair
        int fnm2 = friendsPairing(n-2);
        int pairways = (n-1)*fnm2;

//        total pairs
        int totWays = fnm1+pairways;
        return totWays;
//        or we can write
//        return friendsPairing(n-1)+ (n-1)*friendsPairing(n-1);
    }

    public static void main(String[] args) {
        System.out.print("enter the no. of friends: ");
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println("the no of ways is "+friendsPairing(n));
    }
}
