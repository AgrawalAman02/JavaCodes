package Recursion;

import java.util.Scanner;

public class FirstOccurrance {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,2,10};
        int n,i;
        System.out.println("enter the no.to check its first occurence:");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
//        i is  the starting index from which we want to check
        System.out.println("enter the index of array from where u wannna check:");
        i=sc.nextInt();
        System.out.println(checkFirstOccur(arr,n,i));
    }
    static int checkFirstOccur(int arr[],int n, int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]== n){
            return i;
        }
        return checkFirstOccur(arr,n,i+1);
    }
}
