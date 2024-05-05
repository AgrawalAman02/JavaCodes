package Recursion;

import java.util.Scanner;

public class IncNO {
    public static void main(String[] args) {
        System.out.print("enter the no: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        increasing(n);
    }
    static void increasing(int n){
        if(n==1){
            System.out.println(n);
            return;
        }        increasing(n-1);

        System.out.println(n+" ");
    }
}
