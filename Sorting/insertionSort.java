package Sorting;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr= { 8,3,6,5,4,2};
        int n = arr.length;
        for(int i = 1; i<n; i++){
            int j = i;
            while(j>0 && arr[j]< arr[j-1]){
                // swap a[j] nd a[j-1]
                int temp = arr[j];
                arr[j]= arr[j-1];
                arr[j-1]= temp;
                j--;
            }
        }
        for(int i=0;i<n;i++) {
            System.out.println(arr[i]);
        }
    }
}

/*
space complexity - O(1) so in place algorithm
time complxity - O(n^2) for worst case also for avg case
               - O(n) for best case
it
  is stable

 */
