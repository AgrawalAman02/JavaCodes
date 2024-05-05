package BInarySearch;

import java.util.Scanner;

public class B01_FirstOccurrence {
    public static void main(String[] args) {
        int [] arr = {1,2,2,5,5,5,5,5,6,6,6};
        int fo=-1;
        int lo = 0;
        int hi = arr.length-1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the var to check first occurence : ");
        int var = sc.nextInt();
        while (lo <= hi){
            int mid = lo + (hi - lo )/2;
            if(arr[mid]== var){
                hi = mid - 1 ;
                fo = mid;
            } else if(arr [mid] > var){
                hi = mid -1;
            } else{
                lo = mid + 1;
            }
        }
        System.out.println("The first occurence of the " + var + " is index "+ fo);
    }

}
