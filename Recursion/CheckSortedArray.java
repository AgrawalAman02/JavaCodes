package Recursion;

import java.util.Scanner;

public class CheckSortedArray {
    public static void main(String[] args) {
        int arr[]= {1,2,1,4,5};
        System.out.println(checkSorted(arr, 0)); // i is the starting index
    }
    static boolean checkSorted(int arr[] ,int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return checkSorted(arr,i+1);

    }
}
