package array;

import java.util.Scanner;

public class SortEvenOdd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[]= new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }
        System.out.print("the array before sorting is : ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(" "+arr[i]);
        }
        int i=0,j=arr.length-1;
        while(i<j){
            if(arr[i]%2==0&& i<j) i++;
            if(arr[j]%2!=0&& i<j) j--;
            if(arr[i]%2!=0 && arr[j]%2==0){
                int temp = arr[j];
                arr[j]= arr[i];
                arr[i]= temp;
                i++;
                j--;
            }
        }
        System.out.print("\nthe array after sorting is : ");
        for (i = 0; i < arr.length ; i++) {
            System.out.print(" "+arr[i]);
        }

    }
}
