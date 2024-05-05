package Sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int i,j;
        int[] arr = {2, 1, 6, 3, 9, 4,0};
        for(i=0;i<arr.length-1;i++){  // as loop is going n-1 turn
            for(j=0;j<arr.length-i-1;j++){
//                 last i elements are already in correct sorted positions,
//                 so no need to check again
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                }
            }



        }
        for(i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }

    }

}

/*
space complexity - O(1)
time complxity - O(n^2) for all cases
it is a stable algorithm bcoz duplicate elements retains its position

 */


//        for(i=0;i<arr.length;i++){
//            for(j=i;j<arr.length;j++){
//                if(arr[i]>arr[j]){
//                    int temp = arr[j];
//                    arr[j]= arr[i];
//                    arr[i] = temp;
//                }
//            }
//        looks like selection sort so its sort but it is not bubble sort