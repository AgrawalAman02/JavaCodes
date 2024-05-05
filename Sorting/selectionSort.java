package Sorting;

public class selectionSort {
    public static void main(String[] args) {
        int [] arr = { 1,3,2,9,0,3,6};
        int min = Integer.MAX_VALUE;
        int minIndex=-1;
        for(int i = 0;i<arr.length-1;i++){  //i represent the current index
//
//            int minIndex=i;    can also do this way
//            for(j= i+1;...;..){
//                if(arr[j]<arr[minIndex]){
//                    ...
//                }

            for(int j= i; j<arr.length;j++){
                if(arr[j]<min){
                    minIndex= j;
                }
                if(arr[i]>arr[minIndex]){  // we are comparing with arr[i] because min value are stored at initial poition
                                            // and after that we find the next min value and their index
                    int temp = arr[i];
                    arr[i]= arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }
        for(int i = 0; i< arr.length;i++){
            System.out.println(arr[i]);

        }
    }

}

/*
space complexity - O(1) so in place algorithm
time complxity - O(n^2) for all cases
it
  is unstable

 */
