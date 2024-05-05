// given an integer array 'a' in non decreasing order , return an array of thr squares of each no. sorted in  non decreasing order
package array;

import java.util.Scanner;

public class SortNonDecreasing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the elements of array:");
        int arr[]= new int[5];
        for(int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }
        System.out.print("the array before sorting is : ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(" "+arr[i]);
        }
        int[] sortedSquares = reverse(sortSquares(arr));
        System.out.print("\nthe array after sorting is : ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(" "+sortedSquares[i]);
        }
    }
    static int[] sortSquares(int [] arr){
        int n= arr.length;
        int left=0,right = n-1;
        int[] ans =  new int[n];
        int k=0;

        while(left<=right){
            if(Math.abs(arr[left])>Math.abs(arr[right])){
                ans[k++]= arr[left]*arr[left];
                left++;
            }
            else{
                ans[k++]= arr[right]*arr[right];
                right--;
            }

        }
        return ans;
    }
    static int[] reverse(int[] arr){
        int i=0,j=arr.length-1;
        while(i<=j){
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j]= temp;
            i++;
            j--;
        }
        return arr;
    }
}
