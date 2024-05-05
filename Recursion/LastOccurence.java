package Recursion;

import java.util.Scanner;

public class LastOccurence {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,2,10};
        int n,i;
        System.out.println("enter the no.to check its last occurence:");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
//        i is  the last index from which we want to check
        System.out.println("enter the index of array from where u wannna check:");
        i=sc.nextInt();
        System.out.println(checkLastOccur(arr,n,i));
    }
    static int checkLastOccur(int arr[],int n, int i){
        if(i==arr.length){
            return -1;
        }
        int isFound= checkLastOccur(arr,n,i+1);
        if(isFound==-1&& arr[i]==n){
            return i;
        }
        return isFound;
    }
}
